package com.product.dto;

import lombok.Data;

@Data
public class ProductReviewResponse {
    private String id;
    private String review;
    private int rating;
}
