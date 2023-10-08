package com.airy.ecom.ordersservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderElementReqRes {

    private int elementId;
    private String productName;
    private String desc;
    private String quantity;
    private String imageUrl;
    private String userName;
    private double price;

    public OrderElementReqRes() {
    }

    public OrderElementReqRes(int elementId, String productName, String desc, String quantity, String imageUrl, String userName, double price) {
        this.elementId = elementId;
        this.productName = productName;
        this.desc = desc;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.price = price;
    }
}
