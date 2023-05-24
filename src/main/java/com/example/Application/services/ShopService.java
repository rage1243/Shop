package com.example.Application.services;

import com.example.Application.models.Shop;
import com.example.Application.repositories.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public List<Shop> listShop(String title) {
        if (title != null) return shopRepository.findByNameIgnoreCaseContaining(title);
        return shopRepository.findAll();
    }

    public void saveShop(Shop shop) {
        log.info("Save new object {}", shop);
        shopRepository.save(shop);
    }

    public void deleteProduct(Long id) {
        shopRepository.deleteById(id);
    }

    public Shop getProductById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }
}
