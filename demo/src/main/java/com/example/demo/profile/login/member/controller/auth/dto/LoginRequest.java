package com.example.demo.profile.login.member.controller.auth.dto;
public record LoginRequest(
        String memberEmail,
        String memberPassword
) {
}
