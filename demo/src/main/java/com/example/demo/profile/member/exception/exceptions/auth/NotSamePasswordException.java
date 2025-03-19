package com.example.demo.profile.member.exception.exceptions.auth;

import com.example.demo.profile.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.member.exception.exceptions.MemberException;

public class NotSamePasswordException extends MemberException {

    public NotSamePasswordException() {
        super(MemberErrorCode.NOT_SAME_PASSWORD);
    }
}
