package com.example.Application.controllers;

import com.example.Application.models.Shop;
import com.example.Application.services.ShopCard;
import com.example.Application.services.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CardController {
    private final ShopCard shopCard;
    private final ShopService shopService;

    @PostMapping("shop/addCard/{id}")
    public String addCard(@PathVariable Long id, Model model) {
        Shop shop = shopService.getProductById(id);
        shopCard.add(shop);
        System.out.println(shopCard);
        return "redirect:/shop/catalogue";
    }

    @GetMapping("shop/card")
    public String card(Model model) {
        model.addAttribute("card", shopCard.listShops());
        model.addAttribute("allSum", shopCard.getTotalPrice());
        return "card";
    }

    @PostMapping("shop/delCard/{id}")
    public String card(@PathVariable int id, Model model) {
        System.out.println(id);
        shopCard.deleteFromList(id);
        return "redirect:/shop/card";
    }

}
