package com.product.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repository.ProductRepsitory;
import com.product.service.ProductService;
import com.product.utils.ProductConverter;
@Service
@Validated
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepsitory productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = ProductConverter.toProduct(productRequest, null, null);
        Product savedProduct = productRepository.save(product);
        return ProductConverter.toProductResponse(savedProduct);
    }
    
    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map((product) -> ProductConverter.toProductResponse(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID " + id));
        return ProductConverter.toProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(String id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID " + id));
        Product updatedProduct = ProductConverter.toProduct(productRequest, product.getCategory(), product.getInventory());
        updatedProduct.setId(product.getId());
        Product savedProduct = productRepository.save(updatedProduct);
        return ProductConverter.toProductResponse(savedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID " + id));
        productRepository.delete(product);
    }
}
