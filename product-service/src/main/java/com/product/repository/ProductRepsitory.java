package com.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.entity.Product;

public interface ProductRepsitory extends MongoRepository<Product, String> {

}
