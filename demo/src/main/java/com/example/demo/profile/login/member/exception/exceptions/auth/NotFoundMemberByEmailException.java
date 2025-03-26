package com.example.demo.profile.login.member.exception.exceptions.auth;

import com.example.demo.profile.login.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.login.member.exception.exceptions.MemberException;

public class NotFoundMemberByEmailException extends MemberException {

    public NotFoundMemberByEmailException() {
        super(MemberErrorCode.NOT_FOUND_MEMBER_BY_EMAIL);
    }
}
