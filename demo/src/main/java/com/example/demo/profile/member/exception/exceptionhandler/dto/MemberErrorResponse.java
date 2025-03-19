package com.example.demo.profile.member.exception.exceptionhandler.dto;

public record MemberErrorResponse(
        String customCode,
        String message
) {
}
