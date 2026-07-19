package com.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order_service.dto.ProductResponseDto;


@FeignClient(name="Product-service")
public interface ProductClient {
	
	@GetMapping("api/products/{id}")
	ProductResponseDto getProductById(@PathVariable Long id);

}
