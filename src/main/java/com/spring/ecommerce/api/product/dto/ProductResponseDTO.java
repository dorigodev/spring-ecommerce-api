package com.spring.ecommerce.api.product.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ProductResponseDTO (
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        String imageUrl,
        List<Long> categoryIds
){
}
