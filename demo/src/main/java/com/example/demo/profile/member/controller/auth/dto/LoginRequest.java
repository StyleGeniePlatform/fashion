package com.example.demo.profile.member.controller.auth.dto;
public record LoginRequest(
        String memberEmail,
        String memberPassword
) {
}
