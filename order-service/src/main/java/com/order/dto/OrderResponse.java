package com.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class OrderResponse {
    private UUID id;
    private UUID userId;
    private BigDecimal totalAmount;
    private String status;
    private List<OrderItemResponse> orderItems;
    private PaymentResponse payment;
    private ShippingResponse shipping;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
