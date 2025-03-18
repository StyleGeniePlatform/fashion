package com.example.demo.profile.member.controller.auth.dto;

public record SignUpRequest(
        String memberEmail,
        String memberName,
        String memberPassword,
        String memberNickName

) {
}
