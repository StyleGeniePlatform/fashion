package com.example.demo.profile.login.member.exception.exceptions.auth;

import com.example.demo.profile.login.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.login.member.exception.exceptions.MemberException;

public class InvalidSignUpRequestException extends MemberException {
    public InvalidSignUpRequestException() {
        super(MemberErrorCode.INVALID_SIGNUP_REQUEST);
    }
}
