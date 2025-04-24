package com.trivium.dto;

public class InventoryAlertDTO {
    private String productName;
    private int quantity;
    private String warehouse;

    public InventoryAlertDTO(String productName, int quantity, String warehouse) {
        this.productName = productName;
        this.quantity = quantity;
        this.warehouse = warehouse;
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

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public InventoryAlertDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
