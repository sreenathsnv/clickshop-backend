
package com.trivium.dto;

public class ProductDTO {
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	private Long id;
    private Double price;
    private String description;
    
    // Constructors
    public ProductDTO() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}