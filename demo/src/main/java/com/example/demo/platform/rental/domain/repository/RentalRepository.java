package com.example.demo.platform.rental.domain.repository;


import com.example.demo.platform.rental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
