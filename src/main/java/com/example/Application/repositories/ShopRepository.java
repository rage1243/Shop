package com.example.Application.repositories;

import com.example.Application.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByNameIgnoreCaseContaining(String title);
}