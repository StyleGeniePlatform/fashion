package com.example.demo.profile.login.member.exception.exceptions.auth;

import com.example.demo.profile.login.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.login.member.exception.exceptions.MemberException;

public class NotFoundTokenException extends MemberException {

    public NotFoundTokenException() {
        super(MemberErrorCode.NOT_FOUND_TOKEN_INFORMATION);
    }
}
