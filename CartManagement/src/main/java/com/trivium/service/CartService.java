package com.trivium.service;

import com.trivium.entity.CartItem;
import java.util.List;
import java.util.Map;

public interface CartService {

    List<CartItem> getCartItems(String username);
    CartItem addToCart(String username, Long productId, int quantity);
    void removeFromCart(String username, Long productId);
    double calculateTotalAmount(String username);
    Map<String, Double> calculateAmountPerItemGroup(String username);
    String authorizeAndGetUsername(String token, String requiredRole);
	CartItem updateCartItemQuantity(String token, Long productId, int quantity);
}
