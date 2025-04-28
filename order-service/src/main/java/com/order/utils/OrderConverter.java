package com.order.utils;

import java.util.stream.Collectors;

import com.order.dto.OrderItemRequest;
import com.order.dto.OrderItemResponse;
import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;
import com.order.dto.OrderStatus;
import com.order.dto.PaymentRequest;
import com.order.dto.PaymentResponse;
import com.order.dto.ShippingRequest;
import com.order.dto.ShippingResponse;
import com.order.entity.Order;
import com.order.entity.OrderItem;
import com.order.entity.Payment;
import com.order.entity.Shipping;

public class OrderConverter {
    public static Order toEntity(OrderRequest request) {
        Order order = new Order();
        order.setUserId(Utils.toUUID(request.getUserId()));
        order.setTotalAmount(request.getTotalAmount());
        order.setStatus(OrderStatus.valueOf(request.getStatus().toUpperCase()));
        order.setOrderItems(request.getOrderItems().stream()
                .map(OrderConverter::toEntity)
                .collect(Collectors.toList()));
        order.setPayment(toEntity(request.getPayment()));
        order.setShipping(toEntity(request.getShipping()));
        return order;
    }

    private static OrderItem toEntity(OrderItemRequest request) {
        OrderItem item = new OrderItem();
        item.setProductId(Utils.toUUID(request.getProductId()));
        item.setQuantity(request.getQuantity());
        item.setPrice(request.getPrice());
        return item;
    }

    private static Payment toEntity(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setAmount(request.getAmount());
        return payment;
    }

    private static Shipping toEntity(ShippingRequest request) {
        Shipping shipping = new Shipping();
        shipping.setAddress(request.getAddress());
        shipping.setCity(request.getCity());
        shipping.setPostalCode(request.getPostalCode());
        shipping.setCountry(request.getCountry());
        return shipping;
    }

    public static OrderResponse toDto(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setUserId(order.getUserId());
        response.setTotalAmount(order.getTotalAmount());
        response.setStatus(order.getStatus().name());
        response.setOrderItems(order.getOrderItems().stream()
                .map(OrderConverter::toDto)
                .collect(Collectors.toList()));
        response.setPayment(toDto(order.getPayment()));
        response.setShipping(toDto(order.getShipping()));
        response.setCreatedAt(order.getCreatedAt());
        response.setUpdatedAt(order.getUpdatedAt());
        return response;
    }

    private static OrderItemResponse toDto(OrderItem item) {
        OrderItemResponse response = new OrderItemResponse();
        response.setProductId(item.getProductId());
        response.setQuantity(item.getQuantity());
        response.setPrice(item.getPrice());
        return response;
    }

    private static PaymentResponse toDto(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setAmount(payment.getAmount());
        response.setPaymentStatus(payment.getPaymentStatus().toString());
        return response;
    }

    private static ShippingResponse toDto(Shipping shipping) {
        ShippingResponse response = new ShippingResponse();
        response.setAddress(shipping.getAddress());
        response.setCity(shipping.getCity());
        response.setPostalCode(shipping.getPostalCode());
        response.setCountry(shipping.getCountry());
        return response;
    }
}
