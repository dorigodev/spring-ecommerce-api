package com.spring.ecommerce.api.product.service;

import com.spring.ecommerce.api.product.dto.CategoryRequestDTO;
import com.spring.ecommerce.api.product.dto.CategoryResponseDTO;
import com.spring.ecommerce.api.product.mapper.CategoryMapper;
import com.spring.ecommerce.api.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public CategoryResponseDTO getCategoryById(Long id) {
        return mapper.toCategoryResponseDTO(repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT)));
    }

    public CategoryResponseDTO updateCategoryById(Long id, CategoryRequestDTO request) {
      var existingCategory = repository.findById(id)
              .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
      mapper.updateCategoryFromDto(request,existingCategory);
      return mapper.toCategoryResponseDTO(repository.save(existingCategory));
    }

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }

}
