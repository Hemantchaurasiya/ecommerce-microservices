package com.order.service.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;
import com.order.entity.Order;
import com.order.exception.ResourceNotFoundException;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import com.order.utils.OrderConverter;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Order order = OrderConverter.toEntity(request);
        Order savedOrder = orderRepository.save(order);
        return OrderConverter.toDto(savedOrder);
    }

    @Override
    public OrderResponse getOrderById(UUID id) {
        Order order = orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return OrderConverter.toDto(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
         List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse updateOrder(UUID id, OrderRequest request) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        Order updatedOrder = OrderConverter.toEntity(request);
        updatedOrder.setId(existingOrder.getId()); // Preserve the ID
        Order savedOrder = orderRepository.save(updatedOrder);
        return OrderConverter.toDto(savedOrder);
    }

    @Override
    public void deleteOrder(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        orderRepository.delete(order);
    }

}
