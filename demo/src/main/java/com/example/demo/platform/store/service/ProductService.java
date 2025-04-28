package com.example.demo.platform.store.service;

import com.example.demo.platform.store.controller.dto.ProductRequestDto;
import com.example.demo.platform.store.controller.dto.ProductResponseDto;
import com.example.demo.platform.store.domain.Product;
import com.example.demo.platform.store.domain.ProductRepository;
import com.example.demo.profile.login.member.domain.member.Member;
import com.example.demo.profile.login.member.infrastructure.member.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MemberJpaRepository memberRepository;

    @Value("${admin.email}")
    private String adminEmail;

    public void createProduct(ProductRequestDto dto, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원 없음"));

        extracted(member);

        Product product = new Product(
                dto.getProductName(),
                dto.getImageUrl(),
                dto.getPrice(),
                dto.getDetailPageUrl(),
                dto.getType()
        );

        productRepository.save(product);
    }

    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(p -> new ProductResponseDto(
                        p.getProductName(),
                        p.getImageUrl(),
                        p.getPrice(),
                        p.getDetailPageUrl()))
                .toList();
    }

    public List<ProductResponseDto> getProductsByType(String type) {
        return productRepository.findByClothesType(type).stream()
                .map(p -> new ProductResponseDto(
                        p.getProductName(),
                        p.getImageUrl(),
                        p.getPrice(),
                        p.getDetailPageUrl()))
                .toList();
    }


    private void extracted(final Member member) {
        if (!member.getMemberEmail().equals(adminEmail)) {
            throw new RuntimeException("관리자만 등록 가능");
        }
    }

}
