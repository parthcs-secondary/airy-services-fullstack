package com.airy.ecom.ordersservice.model;


import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "order_details_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "order_amount")
    private double orderAmount;

    @OneToMany()
    @JoinColumn(name = "order_elements")
    private List<OrderElements> orderElements = new ArrayList<OrderElements>();

    @Column(name = "order_status")
    private String orderStatus;


    public Order() {
    }

    public Order(String userName, double orderAmount, List<OrderElements> orderElements, String orderStatus) {
        this.userName = userName;
        this.orderAmount = orderAmount;
        this.orderElements = orderElements;
        this.orderStatus = orderStatus;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<OrderElements> getOrderElements() {
        return orderElements;
    }

    public void setOrderElements(List<OrderElements> orderElements) {
        this.orderElements = orderElements;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


}
