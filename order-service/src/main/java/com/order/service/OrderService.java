package com.order.service;

import java.util.List;
import java.util.UUID;

import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);
    OrderResponse getOrderById(UUID id);
    List<OrderResponse> getAllOrdersOfUser(UUID userId);
    OrderResponse updateOrder(UUID id, OrderRequest request);
    OrderResponse cancelOrder(UUID id);
}
