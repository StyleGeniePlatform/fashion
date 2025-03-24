package com.example.demo.profile.login.member.exception.exceptions;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException{

    private final MemberErrorCode errorCode;

    public MemberException(MemberErrorCode errorCode) {
        super(errorCode.getCustomCode() + ": " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
