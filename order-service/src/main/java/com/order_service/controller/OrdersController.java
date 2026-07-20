package com.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Product_service.dto.ProductResponseDto;
import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;
import com.order_service.service.OrderService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/orders")
@Validated
public class OrdersController {
	@Autowired
	private OrderService orderService;
	@PostMapping
	public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderRequestDto dto){
		OrderResponseDto response = orderService.createOrder(dto);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	

}
