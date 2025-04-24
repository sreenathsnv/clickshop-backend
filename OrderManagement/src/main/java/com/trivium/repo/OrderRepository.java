package com.trivium.repo;

import com.trivium.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUsername(String username);
}