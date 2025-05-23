package com.spring.ecommerce.api.product.repository;

import com.spring.ecommerce.api.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
