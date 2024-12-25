package com.order.service;

import java.util.List;
import java.util.UUID;

import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    OrderResponse getOrderById(UUID id);
    List<OrderResponse> getAllOrders();
    OrderResponse updateOrder(UUID id, OrderRequest request);
    void deleteOrder(UUID id);
}
