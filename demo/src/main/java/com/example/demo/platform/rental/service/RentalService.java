package com.example.demo.platform.rental.service;

import com.example.demo.platform.rental.controller.dto.RentalPostDTO;
import com.example.demo.platform.rental.domain.entity.Rental;
import com.example.demo.platform.rental.domain.repository.RentalRepository;
import com.example.demo.profile.login.member.domain.member.Member;
import com.example.demo.profile.login.member.infrastructure.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository repository;
    private final MemberJpaRepository memberJpaRepository;

    public Rental createRentalPost(Long memberId, String title, int price, String content, String imageURL) {
        Member member = memberJpaRepository
                .findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 존재하지 않습니다."));

        Rental rental = new Rental(
                memberId,
                title,
                price,
                content,
                imageURL);

        return repository.save(rental);
    }

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }
}
