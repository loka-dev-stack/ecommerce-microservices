package com.order_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> handleOrderNotFound(OrderNotFoundException msg){
		return new ResponseEntity<>(msg.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidException(MethodArgumentNotValidException exc){
		
		 Map<String, String> errors = new HashMap<>();

		    exc.getBindingResult().getFieldErrors().forEach(error ->
		        errors.put(error.getField(), error.getDefaultMessage())
		    );

		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		
	}

}
