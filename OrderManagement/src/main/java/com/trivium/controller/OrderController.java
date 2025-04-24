package com.trivium.controller;

import com.trivium.dto.OrderDTO;
import com.trivium.dto.OrderStatsDTO;
import com.trivium.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;



	// Buy product directly with product ID and quantity
	@PostMapping("/product")
	public ResponseEntity<OrderDTO> createOrderFromProduct(@RequestHeader("Authorization") String token,
			@RequestParam Long productId, @RequestParam(required = false, defaultValue = "1") Integer quantity) {
		try {
			OrderDTO order = orderService.createOrderFromProduct(token, productId, quantity);
			return ResponseEntity.ok(order);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	// Buy products from cart
	@PostMapping("/cart")
	public ResponseEntity<OrderDTO> createOrderFromCart(@RequestHeader("Authorization") String token) {
		try {
			OrderDTO order = orderService.createOrderFromCart(token);
			return ResponseEntity.ok(order);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	// View all orders
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders(@RequestHeader("Authorization") String token) {
		try {
			List<OrderDTO> orders = orderService.getAllOrders(token);
			return ResponseEntity.ok(orders);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	// View a particular order
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
		try {
			OrderDTO order = orderService.getOrderById(token, id);
			return ResponseEntity.ok(order);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	// Cancel an order
	@PutMapping("/{id}/cancel")
	public ResponseEntity<OrderDTO> cancelOrder(@RequestHeader("Authorization") String token, @PathVariable Long id) {
		try {
			OrderDTO order = orderService.cancelOrder(token, id);
			return ResponseEntity.ok(order);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/stats")
	public ResponseEntity<OrderStatsDTO> getOrderStats(@RequestHeader("Authorization") String token) {
	    try {
	        OrderStatsDTO stats = orderService.getOrderStats(token);
	        return ResponseEntity.ok(stats);
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(null);
	    }
	}
	
	
	@GetMapping("/admin/orders")
	public ResponseEntity<?> getAllOrdersForAdmin(@RequestHeader("Authorization") String token) {

	    List<OrderDTO> orders = orderService.getAllOrdersAdmin(token);  // Call service method
	    return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/validate-review")
	public ResponseEntity<Boolean> canUserReviewProduct(@RequestHeader("Authorization") String token,
	                                                    @RequestParam Long productId) {
	    try {
	        boolean canReview = orderService.canUserReviewProduct(token,productId);
	        return ResponseEntity.ok(canReview);
	    } catch (RuntimeException e) {
	        return ResponseEntity.ok(false); // fail-safe: treat errors as no-access
	    }
	}


}