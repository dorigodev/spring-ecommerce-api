package com.spring.ecommerce.api.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ProductCreateRequestDTO(
        @NotBlank
        String name,

        String description,

        @Min(1)
        @NotBlank
        BigDecimal price,

        @Min(1)
        Integer stockQuantity,

        String imageUrl,

        @NotNull
        @NotEmpty
        List<Long> categoryIds
) {
}
