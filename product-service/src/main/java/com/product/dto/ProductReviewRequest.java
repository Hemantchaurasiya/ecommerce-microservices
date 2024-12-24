package com.product.dto;

import lombok.Data;

@Data
public class ProductReviewRequest {
    private String review;
    private int rating;
}
