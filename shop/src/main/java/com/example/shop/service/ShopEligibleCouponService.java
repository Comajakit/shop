package com.example.shop.service;
import com.example.shop.entity.Shop;
import com.example.shop.entity.ShopEligibleCoupon;

import java.util.List;

public interface ShopEligibleCouponService {

    ShopEligibleCoupon createShopCoupon(ShopEligibleCoupon shopEligibleCoupon);
    void deleteShopCoupon(Long id,String couponId);
    boolean checkDuplicate(ShopEligibleCoupon shopEligibleCoupon);

    List<ShopEligibleCoupon> findShopEligibleByShopId(Long id);

}
