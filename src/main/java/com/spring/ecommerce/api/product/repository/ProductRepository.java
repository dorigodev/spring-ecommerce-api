package com.spring.ecommerce.api.product.repository;

import com.spring.ecommerce.api.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
