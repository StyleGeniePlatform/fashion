package com.example.demo.platform.rental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "rent")
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
    private String imageData; // 변경된 부분

    @Column(nullable = false)
    private int likeCount = 0;  // 기본값 0

    public Rental(final Long memberId, final String title, final int price, final String content, final String imageData) {
        this.memberId = memberId;
        this.title = title;
        this.price = price;
        this.content = content;
        this.imageData = imageData;
        this.likeCount = 0;  // 기본값 설정
    }

    // 좋아요 증가 메서드
    public void increaseLike() {
        this.likeCount++;
    }

    // 좋아요 감소 메서드
    public void decreaseLike() {
        if (this.likeCount > 0) {
            this.likeCount--;
        }
    }

}
