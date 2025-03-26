package com.example.demo.platform.rental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "rent")
@NoArgsConstructor
@Getter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column
    private String title;

    @Column
    private int price;

    @Column
    private String content;

    @Column
    private String imageData; // 변경된 부분

    public Rental(final Long memberId, final String title, final int price, final String content, final String imageData) {
        this.memberId = memberId;
        this.title = title;
        this.price = price;
        this.content = content;
        this.imageData = imageData;
    }

}
