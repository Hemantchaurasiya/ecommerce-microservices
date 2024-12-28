package com.product.service;

import java.util.List;

import com.product.dto.CategoryRequest;
import com.product.dto.CategoryResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    CategoryResponse getCategoryById(String id);
    List<CategoryResponse> getAllCategories();
    CategoryResponse updateCategory(String id, CategoryRequest categoryRequest);
    boolean deleteCategory(String id);
}
