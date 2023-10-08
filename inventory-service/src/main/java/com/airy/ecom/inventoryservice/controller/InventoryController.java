package com.airy.ecom.inventoryservice.controller;


import com.airy.ecom.inventoryservice.model.Inventory;
import com.airy.ecom.inventoryservice.model.dto.InventoryReqRes;
import com.airy.ecom.inventoryservice.service.InventoryService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private final ModelMapper modelMapper;

    public InventoryController(InventoryService inventoryService, ModelMapper modelMapper){
        this.inventoryService = inventoryService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @GetMapping("/inStock/{productName}")
    public ResponseEntity isInStock(@PathVariable String productName){
        return ResponseEntity.ok(inventoryService.isInStock(productName));
    }

    @Transactional
    @GetMapping("/isInStock")
    public ResponseEntity isInStock(@RequestParam List<String> productName){
        return ResponseEntity.ok(inventoryService.isInStock(productName));
    }

    @PostMapping("/loadInventory")
    public ResponseEntity loadInventory(@RequestBody List<InventoryReqRes> inventoryReqResList){
        List<Inventory> inventoryList = inventoryReqResList.stream()
                .map(inventoryReqRes -> modelMapper.map(inventoryReqRes,Inventory.class))
                .toList();
        return ResponseEntity.ok(inventoryService.loadInventory(inventoryList));
    }

    @PostMapping("/addToInventory")
    public ResponseEntity addToInventory(@RequestBody InventoryReqRes inventoryReqRes){
        Inventory inventory = modelMapper.map(inventoryReqRes, Inventory.class);
        return ResponseEntity.ok(inventoryService.loadInventory(inventory));
    }
}
