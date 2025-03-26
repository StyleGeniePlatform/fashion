package com.example.demo.platform.rental.service;

import com.example.demo.platform.rental.controller.dto.RentalPostDTO;
import com.example.demo.platform.rental.domain.entity.Rental;
import com.example.demo.platform.rental.domain.repository.RentalRepository;
import com.example.demo.platform.rental.exception.NotFoundMember;
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
        foundMember(memberId);
        Rental rental = getRental(memberId, title, price, content, imageURL);
        return repository.save(rental);
    }

    private static Rental getRental(final Long memberId, final String title, final int price, final String content, final String imageURL) {
        return new Rental(
                memberId,
                title,
                price,
                content,
                imageURL);
    }

    private void foundMember(final Long memberId) {
        Member member = memberJpaRepository
                .findById(memberId)
                .orElseThrow(NotFoundMember::new);
    }

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }
}
