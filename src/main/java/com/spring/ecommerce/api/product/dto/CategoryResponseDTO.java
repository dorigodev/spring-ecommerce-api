package com.spring.ecommerce.api.product.dto;

import lombok.Builder;

@Builder
public record CategoryResponseDTO(
        Long id,
        String name,
        String description
) {
}
