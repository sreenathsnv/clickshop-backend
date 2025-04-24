package com.trivium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trivium.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
