package com.spring.ecommerce.api.product.mapper;

import com.spring.ecommerce.api.product.dto.CategoryRequestDTO;
import com.spring.ecommerce.api.product.dto.CategoryResponseDTO;
import com.spring.ecommerce.api.product.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category toCategoryEntity(CategoryRequestDTO dto);

    CategoryResponseDTO toCategoryResponseDTO(Category category);

    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDto(CategoryRequestDTO dto, @MappingTarget Category category);
}

