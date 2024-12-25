package com.order.dto;

import lombok.Data;

@Data
public class ShippingResponse {
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
