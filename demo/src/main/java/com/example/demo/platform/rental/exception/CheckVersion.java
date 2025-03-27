package com.example.demo.platform.rental.exception;

public class CheckVersion extends RuntimeException{
    public CheckVersion() {
        super("버전 충돌 체크 ");
    }
}
