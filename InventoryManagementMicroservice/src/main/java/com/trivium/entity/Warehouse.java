package com.trivium.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<ProductStock> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<ProductStock> getProducts() {
		return products;
	}

	public void setProducts(List<ProductStock> products) {
		this.products = products;
	}

	public Warehouse(Long id, String location, List<ProductStock> products) {
		super();
		this.id = id;
		this.location = location;
		this.products = products;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
