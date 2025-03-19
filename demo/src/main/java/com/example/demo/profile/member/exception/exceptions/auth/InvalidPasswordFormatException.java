package com.example.demo.profile.member.exception.exceptions.auth;

import com.example.demo.profile.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.member.exception.exceptions.MemberException;

public class InvalidPasswordFormatException extends MemberException {
    public InvalidPasswordFormatException(){
        super(MemberErrorCode.INVALID_PASSWORD);
    }
}
