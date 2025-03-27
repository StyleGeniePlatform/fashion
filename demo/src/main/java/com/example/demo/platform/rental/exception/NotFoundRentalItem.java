package com.example.demo.platform.rental.exception;

public class NotFoundRentalItem extends IllegalArgumentException{
    public NotFoundRentalItem() {
        System.out.println("렌탈 항목을 찾을 수 없습니다.");
    }
}
