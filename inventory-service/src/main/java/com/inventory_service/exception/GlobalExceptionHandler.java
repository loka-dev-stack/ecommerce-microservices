package com.inventory_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InventoryNotFoundException.class)
	public ResponseEntity<String> inventoryNotFoundException(InventoryNotFoundException msg){
		return new ResponseEntity<>(msg.getMessage(),HttpStatus.NOT_FOUND);
		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND)
//	            .body(ex.getMessage());
//		
	}

}
