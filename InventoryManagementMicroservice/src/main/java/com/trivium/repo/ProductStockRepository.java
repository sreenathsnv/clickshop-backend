package com.trivium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trivium.entity.ProductStock;

import java.util.List;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
    List<ProductStock> findByQuantityLessThan(int threshold);
    List<ProductStock> findByProductNameContainingIgnoreCase(String name);
}
