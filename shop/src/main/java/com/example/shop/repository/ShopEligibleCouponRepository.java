package com.example.shop.repository;

import com.example.shop.entity.ShopEligibleCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopEligibleCouponRepository extends JpaRepository<ShopEligibleCoupon,Long> {
    ShopEligibleCoupon findByShopIdAndCouponId(Long shopId, String couponId);
    List<ShopEligibleCoupon> findByShopId(Long customerId);
}
