package com.order.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentRequest {
    private String paymentMethod;
    private BigDecimal amount;
}
