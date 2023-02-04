package com.example.shop.controller;

import com.example.shop.entity.Shop;
import com.example.shop.entity.ShopEligibleCoupon;
import com.example.shop.service.ShopEligibleCouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eligible-coupons")
public class ShopEligibleCouponController {

    private final ShopEligibleCouponService service;

    public ShopEligibleCouponController(ShopEligibleCouponService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createShopEligibleCoupon(@RequestBody ShopEligibleCoupon shopEligibleCoupon) {
        if(service.checkDuplicate(shopEligibleCoupon)){
            return ResponseEntity.badRequest().body("Duplicate CouponId");
        }
        ShopEligibleCoupon createdShopEligibleCoupon = service.createShopCoupon(shopEligibleCoupon);
        if (createdShopEligibleCoupon == null){
            return ResponseEntity.badRequest().body("Shop Not Found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShopEligibleCoupon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ShopEligibleCoupon>> getShopById(@PathVariable Long id) {
        List<ShopEligibleCoupon> shopEligibleCoupon = service.findShopEligibleByShopId(id);
        if (shopEligibleCoupon.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(shopEligibleCoupon);
    }


    @DeleteMapping("/{shopId}/{couponId}")
    public ResponseEntity<Void> deleteShopEligibleCoupon(@Validated @PathVariable Long shopId, @PathVariable String couponId) {
        service.deleteShopCoupon(shopId,couponId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

