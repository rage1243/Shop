package com.example.Application.services;

import com.example.Application.models.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@SessionScope
@RequiredArgsConstructor
public class ShopCard {
    //private final ShopCardRepository shopCardRepository;

    private final List<Shop> shops = new ArrayList<>();

    public void add(Shop shop) {
        shops.add(shop);
    }

    public void clear() {
        shops.clear();
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Shop item : listShops()) {
            totalPrice += item.getCost();
        }
        return totalPrice;
    }

    public void deleteFromList(int id) {
        shops.remove(id);
    }

    public int getOrders() { return shops.size(); }

    public List<Shop> listShops() {
        return shops;
    }

/*    public List<ShopCard> listCard() {
        return shopCardRepository.findAll();
    }*/

}
