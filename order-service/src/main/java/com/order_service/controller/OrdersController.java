package com.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDto> getOrdersById(@PathVariable Long id){
		OrderResponseDto orderById = orderService.getOrderById(id);
		
		return ResponseEntity.ok(orderById) ;
	}
	@GetMapping
	public ResponseEntity<List<OrderResponseDto>> getAllOrders(){
		
		return ResponseEntity.ok(orderService.getAllOrders());	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable Long id ,@RequestBody OrderRequestDto dto){
		return ResponseEntity.ok(orderService.updateOrder(id, dto));
	}
	@DeleteMapping("/{id}")
      public ResponseEntity<String> deleteById(@PathVariable Long id) {
    	  orderService.deleteById(id);
		  return ResponseEntity.ok("Order Deleted Succesfully");
      }
}
