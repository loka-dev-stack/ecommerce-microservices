package com.Product_service.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	List<Product> findByCategory(String category);
	List<Product> findByName(String name);
	List<Product> findByNameAndPrice(String name, BigDecimal price );
	
	List<Product> findByPriceLessThan(BigDecimal price);
	List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
	List<Product> findByNameContaining(String name);
}
