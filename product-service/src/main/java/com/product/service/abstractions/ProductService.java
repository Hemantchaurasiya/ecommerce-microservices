package com.product.service.abstractions;

import com.product.dto.requests.ProductRequest;
import com.product.dto.responses.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getAllProductByCategoryId(String categoryId);
    ProductResponse getProductById(String id);
    ProductResponse updateProduct(String id, ProductRequest productRequest);
    void deleteProduct(String id);
}
