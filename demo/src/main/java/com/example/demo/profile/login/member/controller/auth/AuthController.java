package com.example.demo.profile.login.member.controller.auth;

import com.example.demo.profile.login.email.service.EmailService;
import com.example.demo.profile.login.member.controller.auth.dto.LoginRequest;
import com.example.demo.profile.login.member.controller.auth.dto.LoginResponse;
import com.example.demo.profile.login.member.controller.auth.dto.SignUpRequest;
import com.example.demo.profile.login.member.controller.auth.dto.SignUpResponse;

import com.example.demo.profile.login.member.controller.dto.EmailAuthRequestDto;
import com.example.demo.profile.login.member.mapper.auth.AuthMapper;
import com.example.demo.profile.login.member.service.auth.AuthService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final EmailService emailService;

    @PostMapping("/members")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        SignUpResponse signUpResponse = AuthMapper.toSignUpResponse(authService.signUp(signUpRequest));
        URI location = URI.create("/members/" + signUpResponse.id());
        log.info("유저 생성 - {}번 유저 : {}", signUpResponse.id(), signUpResponse.memberNickname());
        return ResponseEntity.created(location).body(signUpResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        log.info("로그인 성공");
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/send-auth-code")
    public String mailConfirm(@RequestBody EmailAuthRequestDto emailDto) throws MessagingException, UnsupportedEncodingException {
        return emailService.sendEmail(emailDto.getEmail());
    }

//
//    @PostMapping("/verify-auth-code")
//    public String verifyAuthCode(@RequestParam String email, @RequestParam String authCode, HttpSession session) {
//        boolean isValid = authCodeService.verifyAuthCode(session, email, authCode);
//        return isValid ? "인증번호가 일치합니다." : "인증번호가 틀립니다.";
//    }

    // EmailRequest 클래스
    @Getter
    public static class EmailRequest {
        private String email;

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
