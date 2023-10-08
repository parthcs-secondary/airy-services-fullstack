package com.airy.ecom.inventoryservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_details_table")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity_available")
    private Integer inventory;

    public Inventory() {
    }

    public Inventory(Long id, String productName, Integer inventory) {
        this.id = id;
        this.productName = productName;
        this.inventory = inventory;
    }

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

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
