//package com.example.demo.profile.login.email.service;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.Random;
//
//@Service
//public class AuthCodeService {
//
//    private final EmailService emailService;
//
//    public AuthCodeService(final EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    public String generateAuthCode(HttpSession session, String email) {
//        String authCode = generateRandomCode();
//        session.setAttribute(email, authCode);
//        emailService.sendEmail(email, "회원가입 인증번호", "인증번호는 " + authCode + "입니다.");
//        return authCode;
//    }
//
//    public boolean verifyAuthCode(HttpSession session, String email, String inputCode) {
//        String storedCode = (String) session.getAttribute(email);
//        return storedCode != null && storedCode.equals(inputCode);
//    }
//
//    private String generateRandomCode() {
//        Random random = new Random();
//        int code = random.nextInt(999999);
//        return String.format("%06d", code); // 6자리 숫자 형식
//    }
//}
