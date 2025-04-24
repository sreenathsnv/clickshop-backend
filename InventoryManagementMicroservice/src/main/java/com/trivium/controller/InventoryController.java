package com.trivium.controller;



import com.trivium.dto.InventoryAlertDTO;
import com.trivium.entity.ProductStock;
import com.trivium.entity.Warehouse;
import com.trivium.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @GetMapping("/alerts")
    public List<InventoryAlertDTO> getLowStockAlerts() {
        return inventoryService.getLowStockAlerts();
    }

    @PostMapping("/warehouse")
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
        return inventoryService.addWarehouse(warehouse);
    }

    @GetMapping("/warehouses")
    public List<Warehouse> getAllWarehouses() {
        return inventoryService.getAllWarehouses();
    }

    @GetMapping("/search")
    public List<ProductStock> search(@RequestParam String q) {
        return inventoryService.searchProducts(q);
    }
}
