package com.example.shop.service;

import com.example.shop.entity.Shop;
import com.example.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop updateShop(Long id, Shop shop) {
        Shop existingShop = shopRepository.findById(id).orElse(null);
        if (existingShop == null) {
            return null;
        }
        existingShop.setName(shop.getName());
        existingShop.setStatus(shop.getStatus());
        return shopRepository.save(existingShop);
    }


    @Override
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}