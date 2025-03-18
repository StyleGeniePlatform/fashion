package com.example.demo.profile.global.exception.exceptionhandler.dto;

public record ErrorResponse(
        String customCode,
        String message
) {
}
