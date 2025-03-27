package com.example.demo.platform.rental.controller;

import com.example.demo.platform.rental.controller.dto.RentalDTO;
import com.example.demo.platform.rental.controller.dto.RentalPostDTO;
import com.example.demo.platform.rental.domain.entity.Rental;
import com.example.demo.platform.rental.service.RentalService;
import com.example.demo.profile.login.global.annotation.Member;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/post")
    public ResponseEntity<Rental> createRental(@Member Long memberId,
                                               @RequestBody RentalPostDTO request) {
        Rental rental = rentalService.createRentalPost(memberId, request.title(), request.price(), request.content(), request.imageURL());
        return ResponseEntity.ok(rental);
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> getAllRentals() {
        return ResponseEntity.ok(rentalService.getAllRentals());
    }

    // 좋아요 증가
    @PostMapping("/{rentalId}/like")
    public ResponseEntity<Rental> increaseLike(@Member Long memberId, @PathVariable Long rentalId) {
        Rental rental = rentalService.increaseLike(memberId, rentalId);
        return ResponseEntity.ok(rental);
    }

    // 좋아요 감소
    @PostMapping("/{rentalId}/dislike")
    public ResponseEntity<Rental> decreaseLike(@Member Long memberId, @PathVariable Long rentalId) {
        Rental rental = rentalService.decreaseLike(memberId, rentalId);
        return ResponseEntity.ok(rental);
    }

}
