
package com.trivium.service;

import com.trivium.dto.OrderDTO;
import com.trivium.dto.OrderStatsDTO;
import com.trivium.entity.Order;

import java.util.List;

public interface OrderService {
    OrderDTO createOrderFromProduct(String token, Long productId, Integer quantity);
    OrderDTO createOrderFromCart(String token);
    List<OrderDTO> getAllOrders(String token);
    OrderDTO getOrderById(String token, Long orderId);
    OrderDTO cancelOrder(String token, Long orderId);
    OrderStatsDTO getOrderStats(String token);
    List<OrderDTO> getAllOrdersAdmin(String token) ;
	boolean canUserReviewProduct(String token,Long productId);
}