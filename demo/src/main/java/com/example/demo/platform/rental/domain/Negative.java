package com.example.demo.platform.rental.domain;

import lombok.Getter;

@Getter
public enum Negative {

    ONE("시발"),
    TWO("병신"),
    THREE("개새끼"),
    ;

    private final String negativeMessage;

    Negative(final String negativeMessage) {
        this.negativeMessage = negativeMessage;
    }
}
