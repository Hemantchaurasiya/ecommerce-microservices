package com.product.utils;

import java.util.List;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.entity.Inventory;
import com.product.entity.Product;
import com.product.entity.Category;

public class ProductConverter {

    // Convert ProductRequest to Product
    public static Product toProduct(ProductRequest productRequest, Category category, Inventory inventory) {
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setAvailable(productRequest.isAvailable());
        product.setCategory(category); // Assuming category is passed or fetched by ID
        product.setImagesUrl(productRequest.getImages());
        product.setReviews(List.of()); // If reviews are not part of request, initialize as empty
        product.setDiscounts(List.of()); // If discounts are not part of request, initialize as empty
        product.setInventory(inventory); // Assuming inventory is passed or fetched by ID
        return product;
    }

    // Convert Product to ProductRequest
    public static ProductRequest toProductRequest(Product product) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(product.getId());
        productRequest.setName(product.getName());
        productRequest.setDescription(product.getDescription());
        productRequest.setPrice(product.getPrice());
        productRequest.setAvailable(product.isAvailable());
        productRequest.setCategoryId(product.getCategory() != null ? product.getCategory().getId() : null);
        productRequest.setImages(product.getImagesUrl());
        return productRequest;
    }

    // Convert Product to ProductResponse
    public static ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setAvailable(product.isAvailable());

        // Assuming inventory quantity is stored as a field in Inventory object
        productResponse.setQuantity(product.getInventory() != null ? String.valueOf(product.getInventory().getQuantity()) : "0");

        productResponse.setImagesUrl(product.getImagesUrl());
        
        // Convert Category to CategoryResponse
        if (product.getCategory() != null) {
            productResponse.setCategory(CategoryConverter.toCategoryResponse(product.getCategory()));
        }
        
        return productResponse;
    }
}

