package com.order.service.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.order.clients.ProductClient;
import com.order.clients.UserClient;
import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;
import com.order.dto.OrderStatus;
import com.order.dto.ProductResponse;
import com.order.dto.UserResponse;
import com.order.entity.Order;
import com.order.exception.ResourceNotFoundException;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import com.order.utils.OrderConverter;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userServiceClient;
    private final ProductClient productClient;

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        Order order = OrderConverter.toEntity(request);
        UserResponse user = userServiceClient.getUserById(request.getUserId().toString());
        // ProductResponse product = productClient.getProductById(request.getProductId().toString());
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
    public List<OrderResponse> getAllOrdersOfUser(UUID userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
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
    public OrderResponse cancelOrder(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        order.setStatus(OrderStatus.CANCELLED);
        Order savedOrder = orderRepository.save(order);
        return OrderConverter.toDto(savedOrder);
    }

}
