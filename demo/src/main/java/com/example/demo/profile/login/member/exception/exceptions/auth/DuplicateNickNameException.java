package com.example.demo.profile.login.member.exception.exceptions.auth;

import com.example.demo.profile.login.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.login.member.exception.exceptions.MemberException;

public class DuplicateNickNameException extends MemberException {

    public DuplicateNickNameException() {
        super(MemberErrorCode.DUPLICATED_NICK_NAME);
    }
}
