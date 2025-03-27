package com.example.demo.platform.rental.controller.dto;

public record RentalDTO (
        String title,
        int likeCount,
        String content,
        String url,
        int price
){
}
