package com.example.shop.service;

import com.example.shop.entity.Shop;

import java.util.List;

public interface ShopService {
    Shop getShopById(Long id);
    List<Shop> getAllShops();
    Shop createShop(Shop shop);
    Shop updateShop(Long id,Shop shop);
    void deleteShop(Long id);
}