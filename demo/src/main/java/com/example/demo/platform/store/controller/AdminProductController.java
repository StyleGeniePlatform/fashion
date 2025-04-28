package com.example.demo.platform.store.controller;

import com.example.demo.platform.store.controller.dto.ProductRequestDto;
import com.example.demo.platform.store.service.ProductService;
import com.example.demo.profile.login.global.annotation.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@Member Long memberId,
                                              @RequestBody ProductRequestDto dto) {
        productService.createProduct(dto, memberId);
        return ResponseEntity.ok().build();
    }
}
