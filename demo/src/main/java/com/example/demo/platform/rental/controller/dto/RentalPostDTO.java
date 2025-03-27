package com.example.demo.platform.rental.controller.dto;

public record RentalPostDTO(
        String title,
        int price,
        String content,
        String imageURL
) {
}
