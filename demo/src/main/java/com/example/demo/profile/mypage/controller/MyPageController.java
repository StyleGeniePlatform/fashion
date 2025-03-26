package com.example.demo.profile.mypage.controller;

import com.example.demo.profile.login.global.annotation.Member;

import com.example.demo.profile.mypage.controller.dto.MyPageResponse;

import com.example.demo.profile.mypage.service.MyPageService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/profile")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping
    public ResponseEntity<MyPageResponse> myPageData(@Member Long memberId) {
        MyPageResponse response = myPageService.myPage(memberId);
        return ResponseEntity.ok(response);
    }
}
