package com.order.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentResponse {
    private String paymentMethod;
    private BigDecimal amount;
    private String paymentStatus;
}
