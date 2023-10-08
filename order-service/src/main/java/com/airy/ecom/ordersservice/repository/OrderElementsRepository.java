package com.airy.ecom.ordersservice.repository;

import com.airy.ecom.ordersservice.model.OrderElements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderElementsRepository extends JpaRepository<OrderElements, Integer> {

    public List<OrderElements> findByUserName(String userName);

    public Integer deleteByUserName(String userName);

    public Integer deleteByProductName(String productName);

    public OrderElements findByUserNameAndProductName(String userName, String productName);
}
