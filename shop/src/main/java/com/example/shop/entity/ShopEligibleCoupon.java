package com.example.shop.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "shop_eligible_coupons")
@Data
public class ShopEligibleCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String couponId;
    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;
}

