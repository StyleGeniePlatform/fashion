package com.example.demo.platform.rental.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rental {

    @Id
    @Column
    private Long memberId;

    @Column
    private String title;

    @Column
    private String price;

    @Column
    private String content;

}
