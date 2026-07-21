package com.order_service.exception;

public class OrderNotFoundException extends RuntimeException{
	
	public OrderNotFoundException(String msg) {
		super(msg);
	}

}
