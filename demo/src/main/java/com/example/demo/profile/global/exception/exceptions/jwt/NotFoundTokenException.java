package com.example.demo.profile.global.exception.exceptions.jwt;


import com.example.demo.profile.global.exception.exceptions.CustomErrorCode;
import com.example.demo.profile.global.exception.exceptions.CustomException;

public class NotFoundTokenException extends CustomException {

    public NotFoundTokenException() {
        super(CustomErrorCode.NOT_FIND_TOKEN);
    }
}
