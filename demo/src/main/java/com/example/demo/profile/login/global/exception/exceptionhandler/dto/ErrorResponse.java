package com.example.demo.profile.login.global.exception.exceptionhandler.dto;

public record ErrorResponse(
        String customCode,
        String message
) {
}
