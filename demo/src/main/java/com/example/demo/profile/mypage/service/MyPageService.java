package com.example.demo.profile.mypage.service;

import com.example.demo.profile.login.member.domain.member.Member;
import com.example.demo.profile.login.member.infrastructure.member.MemberJpaRepository;

import com.example.demo.profile.mypage.controller.dto.MyPageResponse;
import org.springframework.stereotype.Service;


@Service
public class MyPageService {
    private final MemberJpaRepository memberRepository;

    public MyPageService(final MemberJpaRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MyPageResponse myPage(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 존재하지 않습니다."));
        return new MyPageResponse(
                member.getHeight(),
                member.getWeight(),
                member.getShoeSize()
        );
    }
}

