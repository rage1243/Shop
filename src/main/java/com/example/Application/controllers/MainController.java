package com.example.Application.controllers;

import com.example.Application.models.Shop;
import com.example.Application.services.ShopCard;
import com.example.Application.services.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // This means that this class is a Controller
@RequiredArgsConstructor
public class MainController {
    private final ShopService shopService;
    private final ShopCard shopCard;

    @GetMapping("/shop/catalogue")
    public String shop(@RequestParam(name = "name", required = false) String name, Model model) {
        System.out.println("test + " + name);
        model.addAttribute("shop", shopService.listShop(name));
        System.out.println(shopCard);
        model.addAttribute("counter", shopCard.getOrders());
        return "catalogue";
    }

    @GetMapping("/shop/{id}")
    public String shopInfo(@PathVariable Long id, Model model) {
        model.addAttribute("shop", shopService.getProductById(id));
        return "shop-info";
    }

    @PostMapping(path="shop/add")
    public String addNewShop (Shop shop) {
        shopService.saveShop(shop);
        return "add";
    }

    public int getCountOrders() {
        return shopCard.getOrders();
    }

}
