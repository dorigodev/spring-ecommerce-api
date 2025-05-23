package com.spring.ecommerce.api.product.controller;

import com.spring.ecommerce.api.product.dto.CategoryRequestDTO;
import com.spring.ecommerce.api.product.dto.CategoryResponseDTO;
import com.spring.ecommerce.api.product.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody @Valid CategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategoryById(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid CategoryRequestDTO request) {
        return ResponseEntity.ok(service.updateCategoryById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable @NotNull @Positive Long id) {
        service.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
