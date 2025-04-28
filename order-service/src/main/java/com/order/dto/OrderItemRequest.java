package com.order.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemRequest {
    private String productId;
    private Integer quantity;
    private BigDecimal price;
}
