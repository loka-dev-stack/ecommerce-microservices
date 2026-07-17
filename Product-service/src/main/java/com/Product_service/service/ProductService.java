package com.Product_service.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Product_service.dto.ProductRequestDto;
import com.Product_service.dto.ProductResponseDto;

public interface ProductService {
	
		ProductResponseDto createProduct(ProductRequestDto dto);
			
		List<ProductResponseDto> getAllProducts();
		
		ProductResponseDto getProductById(Long id);
		
		ProductResponseDto getUpdateById(Long id, ProductRequestDto dto);	
		
		void deleteProduct(Long id);
		
//		Page<ProductResponseDto> getAllProducts(int page, int size);
		
		Page<ProductResponseDto> getAllProducts(int page, int size,
				String sortBy, String direction);
			

}
