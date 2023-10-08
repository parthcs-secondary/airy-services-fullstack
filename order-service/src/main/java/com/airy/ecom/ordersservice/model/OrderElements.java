package com.airy.ecom.ordersservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_element_details_table")
public class OrderElements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "element_id")
    private Integer elementId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_desc")
    private String desc;

    @Column(name = "product_quantity")
    private String quantity;

    @Column(name = "product_image_url")
    private String imageUrl;

    @Column(name = "product_price")
    private double price;

    @Column(name = "user_name")
    private String userName;


    public OrderElements() {
    }

    public OrderElements(Integer elementId, String productName, String desc, String quantity, String imageUrl, double price, String userName, Order order) {
        this.elementId = elementId;
        this.productName = productName;
        this.desc = desc;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.price = price;
        this.userName = userName;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
