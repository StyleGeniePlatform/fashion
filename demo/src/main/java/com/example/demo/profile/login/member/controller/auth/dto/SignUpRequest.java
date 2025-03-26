package com.example.demo.profile.login.member.controller.auth.dto;

public record SignUpRequest(
        String memberEmail,
        String memberName,
        String memberPassword,
        String memberNickName,
        String height,
        String weight,
        String showSize
) {
}
