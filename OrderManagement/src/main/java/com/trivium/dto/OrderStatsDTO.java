
package com.trivium.dto;

import java.util.Map;

public class OrderStatsDTO {

	private Long totalOrders;
	private Double totalAmount;
	private Long activeOrders;
	private Long cancelledOrders;
	private Map<String, Double> revenueByMonth;

	// Getters and Setters
	public Long getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getActiveOrders() {
		return activeOrders;
	}

	public void setActiveOrders(Long activeOrders) {
		this.activeOrders = activeOrders;
	}

	public Long getCancelledOrders() {
		return cancelledOrders;
	}

	public void setCancelledOrders(Long cancelledOrders) {
		this.cancelledOrders = cancelledOrders;
	}

	public Map<String, Double> getRevenueByMonth() {
		return revenueByMonth;
	}

	public void setRevenueByMonth(Map<String, Double> revenueByMonth) {
		this.revenueByMonth = revenueByMonth;
	}
}
