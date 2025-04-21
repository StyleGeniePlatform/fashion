package com.example.demo.platform.rental.service;

import com.example.demo.platform.rental.controller.dto.RentalDTO;
import com.example.demo.platform.rental.domain.Negative;
import com.example.demo.platform.rental.domain.entity.Rental;
import com.example.demo.platform.rental.domain.repository.RentalRepository;
import com.example.demo.platform.rental.exception.NegativeContent;
import com.example.demo.platform.rental.exception.NegativeTitle;
import com.example.demo.platform.rental.exception.NotFoundMember;
import com.example.demo.profile.login.member.domain.member.Member;
import com.example.demo.profile.login.member.infrastructure.member.MemberJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class RentalServiceTest {

    private RentalRepository rentalRepository;
    private MemberJpaRepository memberJpaRepository;
    private RentalService rentalService;

    @BeforeEach
    void setUp() {
        rentalRepository = mock(RentalRepository.class);
        memberJpaRepository = mock(MemberJpaRepository.class);
        rentalService = new RentalService(rentalRepository, memberJpaRepository);
    }

    @Test
    void createRentalPost_정상생성() {
        // given
        Long memberId = 1L;
        String title = "정상 제목";
        String content = "정상 내용";
        int price = 10000;
        String imageUrl = "http://test.com/image.jpg";

        given(rentalRepository.save(any(Rental.class))).willAnswer(invocation -> invocation.getArgument(0));

        // when
        Rental result = rentalService.createRentalPost(memberId, title, price, content, imageUrl);

        // then
        assertThat(result.getTitle()).isEqualTo(title);
        assertThat(result.getContent()).isEqualTo(content);
        assertThat(result.getPrice()).isEqualTo(price);
        assertThat(result.getImageData()).isEqualTo(imageUrl);
    }



    @Test
    void createRentalPost_존재하지않는회원_예외() {
        // given
        Long memberId = 99L;
        given(memberJpaRepository.findById(memberId)).willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> rentalService.createRentalPost(memberId, "title", 10000, "content", ""))
                .isInstanceOf(NotFoundMember.class);
    }

    @Test
    void getAllRentals_데이터있을때() {
        // given
        Rental rental = new Rental(1L, "제목", 10000, "내용", "이미지");
        given(rentalRepository.findAll()).willReturn(List.of(rental));

        // when
        List<RentalDTO> results = rentalService.getAllRentals();

        // then
        assertThat(results).hasSize(1);
    }
}
