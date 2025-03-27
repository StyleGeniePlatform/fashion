package com.example.demo.platform.rental.exception;

public class NegativeContent extends IllegalArgumentException{
    public NegativeContent() {
        super("내용에 부적절한 내용이 들어가있습니다.");
    }
}
