package com.example.demo.platform.rental.exception;

public class NegativeTitle extends IllegalArgumentException{
    public NegativeTitle() {
        System.out.println("제목에 부적절한 언어가 포함되어 있습니다.");
    }
}
