package com.example.demo.platform.rental.exception;

public class NotFoundMember extends IllegalArgumentException {
    public NotFoundMember() {
        System.out.println("로그인 해주세요!");
    }
}
