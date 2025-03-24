package com.example.demo.profile.login.member.mapper.auth;

import com.example.demo.profile.login.member.controller.auth.dto.SignUpRequest;
import com.example.demo.profile.login.member.controller.auth.dto.SignUpResponse;

import com.example.demo.profile.login.member.domain.member.Member;

public class AuthMapper {

    public static Member toMember(SignUpRequest signUpRequest) {
        return new Member(
                signUpRequest.memberEmail(),
                signUpRequest.memberName(),
                signUpRequest.memberPassword(),
                signUpRequest.memberNickName()
        );
    }

    public static SignUpResponse toSignUpResponse(Member member) {
        return new SignUpResponse(member.getId(), member.getMemberName(), member.getMemberEmail(),
                member.getMemberPassword(), member.getMemberNickName());
    }
}
