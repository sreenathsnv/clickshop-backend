package com.trivium.dto;

public class ProductStatsDTO {
    private long totalProducts;
    private long availableProducts;
    private long outOfStockProducts;

    // Constructors
    public ProductStatsDTO() {}

    public ProductStatsDTO(long totalProducts, long availableProducts, long outOfStockProducts) {
        this.totalProducts = totalProducts;
        this.availableProducts = availableProducts;
        this.outOfStockProducts = outOfStockProducts;
    }

  
    public long getTotalProducts() { return totalProducts; }
    public void setTotalProducts(long totalProducts) { this.totalProducts = totalProducts; }

    public long getAvailableProducts() { return availableProducts; }
    public void setAvailableProducts(long availableProducts) { this.availableProducts = availableProducts; }

    public long getOutOfStockProducts() { return outOfStockProducts; }
    public void setOutOfStockProducts(long outOfStockProducts) { this.outOfStockProducts = outOfStockProducts; }
}
