package com.example.demo.profile.member.exception.exceptions.auth;

import com.example.demo.profile.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.member.exception.exceptions.MemberException;

public class InvalidSignUpRequestException extends MemberException {
    public InvalidSignUpRequestException() {
        super(MemberErrorCode.INVALID_SIGNUP_REQUEST);
    }
}
