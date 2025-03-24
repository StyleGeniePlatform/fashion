package com.example.demo.profile.login.member.exception.exceptions.member;

import com.example.demo.profile.login.member.exception.exceptions.MemberErrorCode;
import com.example.demo.profile.login.member.exception.exceptions.MemberException;

public class NotFoundMemberDepositException extends MemberException {

    public NotFoundMemberDepositException() {
        super(MemberErrorCode.NOT_FOUND_MEMBER_DEPOSIT);
    }
}
