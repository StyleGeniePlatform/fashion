package com.example.demo.platform.rental.service;

import com.example.demo.platform.rental.domain.Negative;
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
        findMember(memberId);
        validateTitle(title);
        validateContent(content);
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

    private void findMember(final Long memberId) {
        Member member = memberJpaRepository
                .findById(memberId)
                .orElseThrow(NotFoundMember::new);
    }

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    private void validateTitle(String title) {
        for (Negative negative : Negative.values()) {
            if (title.contains(negative.getNegativeMessage())) {
                throw new IllegalArgumentException("제목에 부적절한 언어가 포함되어 있습니다.");
            }
        }
    }

    private void validateContent(String content) {
        for (Negative negative : Negative.values()) {
            if (content.contains(negative.getNegativeMessage())) {
                throw new IllegalArgumentException("내용에 부적절한 언어가 포함되어 있습니다.");
            }
        }
    }
}
