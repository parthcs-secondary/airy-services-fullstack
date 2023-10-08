package com.airy.ecom.ordersservice.model.dto;

import com.airy.ecom.ordersservice.model.OrderElements;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderReqRes {

    private UUID orderId;
    private String userName;
    private double orderAmount;

    private String orderStatus;

    private List<OrderElements> orderElements;

}
