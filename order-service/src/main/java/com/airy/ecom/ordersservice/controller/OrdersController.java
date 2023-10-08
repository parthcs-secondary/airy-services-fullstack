package com.airy.ecom.ordersservice.controller;

import com.airy.ecom.ordersservice.model.Order;
import com.airy.ecom.ordersservice.model.dto.OrderReqRes;
import com.airy.ecom.ordersservice.services.OrderElementService;
import com.airy.ecom.ordersservice.services.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrdersController {

    private final ModelMapper modelMapper;
    private final OrderService orderService;

    public OrdersController(ModelMapper modelMapper, OrderService orderService){
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @Transactional
    @PostMapping("/{userName}/place_order")
    public ResponseEntity<?> placeOrder(@PathVariable String userName){
        System.out.println("UserName from PostMan : "+userName);
        Order placedOrder = orderService.placeOrder(userName);
        if(placedOrder != null){
            OrderReqRes orderReqRes = modelMapper.map(placedOrder,OrderReqRes.class);
            return ResponseEntity.ok(orderReqRes);
        }else{
            return ResponseEntity.ok("Some of the Products are out of Stock, Please Try Again Later");
        }
    }
}
