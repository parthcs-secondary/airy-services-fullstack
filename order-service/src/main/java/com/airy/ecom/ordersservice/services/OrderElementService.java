package com.airy.ecom.ordersservice.services;

import com.airy.ecom.ordersservice.model.OrderElements;
import com.airy.ecom.ordersservice.model.dto.OrderElementReqRes;
import com.airy.ecom.ordersservice.repository.OrderElementsRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderElementService {


    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final OrderElementsRepository orderElementsRepository;

    public OrderElementService(OrderElementsRepository orderElementsRepository, ModelMapper modelMapper){
        this.orderElementsRepository = orderElementsRepository;
        this.modelMapper = modelMapper;
    }

    public OrderElements addToCart(OrderElementReqRes orderElementReqRes){
            OrderElements orderElement = modelMapper.map(orderElementReqRes, OrderElements.class);
            OrderElements savedOrderElement = orderElementsRepository.save(orderElement);
            return savedOrderElement;
    }
    @Transactional
    public OrderElements removeFromCart(OrderElementReqRes orderElementReqRes){
            OrderElements orderElement = modelMapper.map(orderElementReqRes, OrderElements.class);
            orderElementsRepository.deleteByProductName(orderElement.getProductName());
            return orderElement;
    }

    public OrderElements findByUserNameAndProductName(String userName, String productName){
        return orderElementsRepository.findByUserNameAndProductName(userName, productName);
    }

    public List<OrderElements> fetchFromCart(String userName){
        return orderElementsRepository.findByUserName(userName);
    }

    @Transactional
    public void clearCart(String userName){
        orderElementsRepository.deleteByUserName(userName);
    }
}
