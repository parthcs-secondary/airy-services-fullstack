package com.airy.ecom.inventoryservice.repository;

import com.airy.ecom.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    public Optional<Inventory> findByProductName(String productName);

    public List<Inventory> findByProductNameIn(List<String> productNames);
}
