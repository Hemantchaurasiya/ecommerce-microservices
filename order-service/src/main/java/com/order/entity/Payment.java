package com.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.order.dto.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus; // e.g., PENDING, SUCCESS, FAILED

    @Column
    private String transactionId; // Reference from the Payment Service

    @Column
    private String paymentMethod; // e.g., CREDIT_CARD, PAYPAL

    @OneToOne(mappedBy = "payment", fetch = FetchType.LAZY)
    private Order order;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}

