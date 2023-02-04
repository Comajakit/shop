package com.example.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    @OneToMany(mappedBy = "shop")
    @JsonIgnore
    private List<ShopEligibleCoupon> eligibleCoupons;
}