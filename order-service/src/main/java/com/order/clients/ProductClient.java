package com.order.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.dto.ProductResponse;

@FeignClient(name = "product-service", url = "http://localhost:2000/api/v1/products")
public interface ProductClient {

    @PostMapping("/")
    List<ProductResponse> getProductsByIdList(@RequestBody List<String> idList);

    @PutMapping("/{id}")
    ProductResponse updateProductQuatity(@PathVariable("id") String id,@RequestBody String quantity);
}
