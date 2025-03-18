package com.example.demo.profile.member.controller.member;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class a {

    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<Void> showMember() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/members", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top5")
    public ResponseEntity<List<MemberDto>> getTop5Members() {
        List<MemberDto> top5Members = memberService.getTop5MembersByDeposit();
        return ResponseEntity.ok(top5Members);
    }
}
