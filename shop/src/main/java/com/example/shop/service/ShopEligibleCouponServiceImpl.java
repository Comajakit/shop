package com.example.shop.service;

import com.example.shop.entity.Shop;
import com.example.shop.entity.ShopEligibleCoupon;
import com.example.shop.repository.ShopEligibleCouponRepository;
import com.example.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopEligibleCouponServiceImpl implements ShopEligibleCouponService{
    private final ShopEligibleCouponRepository shopEligibleCouponRepository;
    private final ShopRepository shopRepository;

    @Override
    public ShopEligibleCoupon createShopCoupon(ShopEligibleCoupon shopEligibleCoupon) {

        Long shopId = shopEligibleCoupon.getShop().getId();
        String couponId = shopEligibleCoupon.getCouponId();
        Shop shop = shopRepository.findById(shopId).orElse(null);
        if (shop == null) {
            return null;
        }
        ShopEligibleCoupon newShopCoupon = new ShopEligibleCoupon();
        newShopCoupon.setShop(shop);
        newShopCoupon.setCouponId(couponId);

        return shopEligibleCouponRepository.save(newShopCoupon);
    }

    @Override
    public void deleteShopCoupon(Long shopId,String couponId) {
        ShopEligibleCoupon shopCoupon = shopEligibleCouponRepository.findByShopIdAndCouponId(shopId,couponId);
        if(shopCoupon != null){
            shopEligibleCouponRepository.delete(shopCoupon);
        }

    }

    @Override
    public boolean checkDuplicate(ShopEligibleCoupon shopEligibleCoupon) {
        Long shopId = shopEligibleCoupon.getShop().getId();
        String couponId = shopEligibleCoupon.getCouponId();
        ShopEligibleCoupon existingCoupon = shopEligibleCouponRepository.findByShopIdAndCouponId(shopId, couponId);

        if (existingCoupon != null) {
           return true;
        }
        return false;
    }

    @Override
    public List<ShopEligibleCoupon> findShopEligibleByShopId(Long id) {
        return shopEligibleCouponRepository.findByShopId(id);
    }


}
