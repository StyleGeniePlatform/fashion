package com.example.demo.platform.store.controller.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String productName;
    private String imageUrl;
    private int price;
    private String detailPageUrl;
    private String type;
}
