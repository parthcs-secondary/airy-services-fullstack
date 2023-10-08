package com.airy.ecom.ordersservice.services;

import com.airy.ecom.ordersservice.model.Order;
import com.airy.ecom.ordersservice.model.OrderElements;
import com.airy.ecom.ordersservice.model.dto.OrderReqRes;
import com.airy.ecom.ordersservice.model.dto.inventory.InventoryResponse;
import com.airy.ecom.ordersservice.repository.OrderElementsRepository;
import com.airy.ecom.ordersservice.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final OrderElementsRepository orderElementsRepository;

    private final WebClient.Builder webClientBuilder;

    public OrderService(OrdersRepository ordersRepository, OrderElementsRepository orderElementsRepository, WebClient.Builder webClientBuilder){
        this.ordersRepository = ordersRepository;
        this.orderElementsRepository = orderElementsRepository;
        this.webClientBuilder = webClientBuilder;
    }

    public Order placeOrder(String userName){
        List<OrderElements> orderElements = orderElementsRepository.findByUserName(userName);
        Order order = new Order();
        order.setUserName(userName);
        order.setOrderAmount(orderElements.stream()
                .map(OrderElements::getPrice)
                .reduce(0.0,(total, price) -> total+price));
        order.setOrderElements(orderElements);
        order.setOrderStatus("ENTERED");
        List<String> productNames = orderElements.stream()
                        .map(OrderElements::getProductName)
                        .toList();
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                                .uri("http://inventory-service/api/v1/inventory/isInStock"
                                        , uriBuilder -> uriBuilder.queryParam("productName",productNames).build())
                                .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                .block();

        Boolean allProductsInStock = Arrays.stream(inventoryResponses)
                .allMatch(InventoryResponse::isInStock) && inventoryResponses.length == orderElements.size();

        if(allProductsInStock){
            Order placedOrder = ordersRepository.save(order);
            orderElementsRepository.deleteByUserName(userName);
            return placedOrder;
        }else{
            return null;
        }
    }
}
