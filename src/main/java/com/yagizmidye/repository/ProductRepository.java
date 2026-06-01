package com.yagizmidye.repository;

import com.yagizmidye.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByActiveTrue();

    List<Product> findByNameContainingIgnoreCase(String name);
}