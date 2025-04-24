package com.trivium.entity;

import jakarta.persistence.*;

@Entity
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
    private int threshold;  

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public ProductStock(Long id, String productName, int quantity, int threshold, Warehouse warehouse) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.threshold = threshold;
		this.warehouse = warehouse;
	}

	public ProductStock() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
