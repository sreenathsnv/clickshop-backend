package com.trivium.service;


import com.trivium.dto.InventoryAlertDTO;
import com.trivium.entity.ProductStock;
import com.trivium.entity.Warehouse;
import com.trivium.repo.ProductStockRepository;
import com.trivium.repo.WarehouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ProductStockRepository stockRepo;

    @Autowired
    private WarehouseRepository warehouseRepo;

    
    @Override
    public List<InventoryAlertDTO> getLowStockAlerts() {
        List<ProductStock> lowStock = stockRepo.findByQuantityLessThan(10); // hardcoded threshold
        return lowStock.stream()
                .map(p -> new InventoryAlertDTO(p.getProductName(), p.getQuantity(), p.getWarehouse().getLocation()))
                .collect(Collectors.toList());
    }

    @Override
    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepo.findAll();
    }

	@Override
	public ProductStock updateStock(Long id, int newQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductStock addProduct(ProductStock productStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductStock> searchProducts(String query) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
