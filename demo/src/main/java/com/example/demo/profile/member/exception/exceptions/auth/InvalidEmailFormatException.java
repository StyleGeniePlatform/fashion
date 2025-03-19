package com.example.demo.profile.member.exception.exceptions.auth;

import com.example.demo.profile.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.member.exception.exceptions.MemberException;

public class InvalidEmailFormatException extends MemberException {
    public InvalidEmailFormatException() {
        super(MemberErrorCode.INVALID_EMAIL);
    }
}
