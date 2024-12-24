package com.product.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ProductRequest {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available;
    private String categoryId;
    private List<String> images;
}
