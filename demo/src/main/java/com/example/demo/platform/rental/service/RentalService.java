package com.example.demo.platform.rental.service;

import com.example.demo.platform.rental.domain.Negative;
import com.example.demo.platform.rental.domain.entity.Rental;
import com.example.demo.platform.rental.domain.repository.RentalRepository;
import com.example.demo.platform.rental.exception.NegativeContent;
import com.example.demo.platform.rental.exception.NegativeTitle;
import com.example.demo.platform.rental.exception.NotFoundMember;
import com.example.demo.platform.rental.exception.NotFoundRentalItem;
import com.example.demo.profile.login.member.domain.member.Member;
import com.example.demo.profile.login.member.infrastructure.member.MemberJpaRepository;
import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    @Transactional
    public Rental increaseLike(Long memberId, Long rentalId) {
        findMember(memberId);
        Rental rental = repository.findById(rentalId)
                .orElseThrow(NotFoundRentalItem::new);
        rental.increaseLike();
        try {
            return repository.save(rental);
        } catch (OptimisticLockException e) {
            throw new RuntimeException("버전 충돌 체크 ");
        }
    }

    @Transactional
    public Rental decreaseLike(Long memberId, Long rentalId) {
        findMember(memberId);
        Rental rental = repository.findById(rentalId)
                .orElseThrow(NotFoundRentalItem::new);
        rental.decreaseLike();
        try {
            return repository.save(rental);  // 저장 시 버전 충돌을 체크
        } catch (OptimisticLockException e) {
            throw new RuntimeException("버전 충돌 체크 ");
        }
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

    private void validateTitle(String title) {
        for (Negative negative : Negative.values()) {
            if (title.contains(negative.getNegativeMessage())) {
                throw new NegativeTitle();
            }
        }
    }

    private void validateContent(String content) {
        for (Negative negative : Negative.values()) {
            if (content.contains(negative.getNegativeMessage())) {
                throw new NegativeContent();
            }
        }
    }
}
