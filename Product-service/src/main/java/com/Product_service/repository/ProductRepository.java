package com.Product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
