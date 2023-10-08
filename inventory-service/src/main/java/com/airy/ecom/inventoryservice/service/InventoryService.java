package com.airy.ecom.inventoryservice.service;

import com.airy.ecom.inventoryservice.model.Inventory;
import com.airy.ecom.inventoryservice.model.dto.InventoryResponse;
import com.airy.ecom.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public boolean isInStock(String productName){
        return inventoryRepository.findByProductName(productName).isPresent();
    }

    public List<InventoryResponse> isInStock(List<String> productNames){
        return inventoryRepository
                .findByProductNameIn(productNames)
                .stream()
                    .map(inventory -> InventoryResponse.builder()
                            .productName(inventory.getProductName())
                            .inStock(inventory.getInventory() > 0)
                            .build())
                    .toList();
    }


    public List<Inventory> loadInventory(List<Inventory> inventoryList){
         return inventoryRepository.saveAll(inventoryList);
    }

    public Inventory loadInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
}
