package com.product.utils;

import java.util.List;

import com.product.dto.CategoryRequest;
import com.product.dto.CategoryResponse;
import com.product.entity.Category;

public class CategoryConverter {
    // Convert CategoryRequest to Category
    public static Category toCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        // Since CategoryRequest doesn't have an ID, we leave it empty or handle it later
        category.setProducts(List.of()); // If products are not part of the request, initialize as empty
        return category;
    }

    // Convert Category to CategoryResponse
    public static CategoryResponse toCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }
}
