package com.spring.ecommerce.api.product.controller;

import com.spring.ecommerce.api.product.dto.CategoryRequestDTO;
import com.spring.ecommerce.api.product.dto.CategoryResponseDTO;
import com.spring.ecommerce.api.product.mapper.CategoryMapper;
import com.spring.ecommerce.api.product.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody @Valid CategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }
}
