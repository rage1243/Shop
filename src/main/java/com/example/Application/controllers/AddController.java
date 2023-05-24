package com.example.Application.controllers;

import com.example.Application.services.ShopCard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AddController {

    @Autowired
    private final ShopCard shopCard;

    @GetMapping("shop/add")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("counter", shopCard.getOrders());
        return "Add";
    }
}