package com.trivium.service;


import com.trivium.dto.InventoryAlertDTO;
import com.trivium.entity.ProductStock;
import com.trivium.entity.Warehouse;

import java.util.List;

public interface InventoryService {
    ProductStock updateStock(Long id, int newQuantity);
    ProductStock addProduct(ProductStock productStock);
    List<InventoryAlertDTO> getLowStockAlerts();
    Warehouse addWarehouse(Warehouse warehouse);
    List<Warehouse> getAllWarehouses();
    List<ProductStock> searchProducts(String query);
}

