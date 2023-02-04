package com.example.shop.controller;

import com.example.shop.entity.Shop;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {
        Shop shop = shopService.getShopById(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop newShop = shopService.createShop(shop);
        return new ResponseEntity<>(newShop, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        Shop updatedShop = shopService.updateShop(id, shop);
        if (updatedShop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
