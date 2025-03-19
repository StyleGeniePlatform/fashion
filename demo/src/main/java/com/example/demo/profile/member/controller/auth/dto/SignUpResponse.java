package com.example.demo.profile.member.controller.auth.dto;

public record SignUpResponse(
        Long id,
        String memberName,
        String memberEmail,
        String memberPassword,
        String memberNickname
) {
}
