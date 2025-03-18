package com.example.demo.profile.global.exception.exceptions.jwt;


import com.example.demo.profile.global.exception.exceptions.CustomErrorCode;
import com.example.demo.profile.global.exception.exceptions.CustomException;

public class TokenTimeException extends CustomException {

    public TokenTimeException() {
        super(CustomErrorCode.EXPIRED_TOKEN);
    }
}
