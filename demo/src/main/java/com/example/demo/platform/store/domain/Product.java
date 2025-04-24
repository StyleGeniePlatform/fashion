package com.example.demo.platform.store.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String imageUrl;

    private int price;

    private String detailPageUrl;

    private String clothesType;

    public Product(final String productName, final String imageUrl, final int price, final String detailPageUrl, final String clothesType) {

        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.detailPageUrl = detailPageUrl;
        this.clothesType = clothesType;
    }
}
