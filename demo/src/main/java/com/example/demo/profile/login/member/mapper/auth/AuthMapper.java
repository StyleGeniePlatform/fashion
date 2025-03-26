package com.example.demo.profile.login.member.mapper.auth;

import com.example.demo.profile.login.member.controller.auth.dto.LoginResponse;
import com.example.demo.profile.login.member.controller.auth.dto.SignUpRequest;
import com.example.demo.profile.login.member.controller.auth.dto.SignUpResponse;

import com.example.demo.profile.login.member.domain.member.Member;

public class AuthMapper {

    public static Member toMember(SignUpRequest signUpRequest) {
        return new Member(
                signUpRequest.memberEmail(),
                signUpRequest.memberName(),
                signUpRequest.memberPassword(),
                signUpRequest.memberNickName(),
                signUpRequest.height(),
                signUpRequest.weight(),
                signUpRequest.showSize()
        );
    }

    public static SignUpResponse toSignUpResponse(Member member) {
        return new SignUpResponse(member.getId(), member.getMemberName(), member.getMemberEmail(),
                member.getMemberPassword(), member.getMemberNickName());
    }

    public static LoginResponse toLoginResponse(String token, Member member) {
        return new LoginResponse(
                token,
                member.getId(),
                member.getMemberName(),
                member.getMemberNickName()
        );
    }
}
