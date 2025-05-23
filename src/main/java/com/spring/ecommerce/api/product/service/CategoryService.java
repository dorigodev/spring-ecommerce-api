package com.spring.ecommerce.api.product.service;

import com.spring.ecommerce.api.product.dto.CategoryRequestDTO;
import com.spring.ecommerce.api.product.dto.CategoryResponseDTO;
import com.spring.ecommerce.api.product.mapper.CategoryMapper;
import com.spring.ecommerce.api.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        return mapper.toCategoryResponseDTO(
                repository.save(mapper.toCategoryEntity(request))
        );
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return repository.findAll()
                .stream()
                .map(mapper::toCategoryResponseDTO)
                .toList();
    }

}
