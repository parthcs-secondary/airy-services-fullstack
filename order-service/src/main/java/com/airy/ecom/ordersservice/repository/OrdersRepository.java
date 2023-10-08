package com.airy.ecom.ordersservice.repository;

import com.airy.ecom.ordersservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Order, UUID> {
}
