package com.example.demo.platform.rental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    @Column(nullable = false)
    private Long memberId;

    @Column
    private String title;

    @Version  // 낙관적 잠금을 위한 버전 필드
    private Long version;  // 버전 필드 추가

    @Column
    private int price;

    @Column
    private String content;

    @Column
    private String imageData;

    @Column(nullable = false)
    private int likeCount;

    public Rental(final Long memberId, final String title, final int price, final String content, final String imageData) {
        this.memberId = memberId;
        this.title = title;
        this.price = price;
        this.content = content;
        this.imageData = imageData;
        this.likeCount = 0;
    }

    public void increaseLike() {
        this.likeCount++;
    }

    public void decreaseLike() {
        if (this.likeCount > 0) {
            this.likeCount--;
        }
    }
}
