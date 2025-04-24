package com.example.demo.platform.store.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponseDto {
    private String productName;
    private String imageUrl;
    private int price;
    private String detailPageUrl;
}
