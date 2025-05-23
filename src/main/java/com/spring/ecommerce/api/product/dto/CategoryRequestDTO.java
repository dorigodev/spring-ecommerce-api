package com.spring.ecommerce.api.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CategoryRequestDTO(
        @NotBlank
        String name,

        String description
) {
}
