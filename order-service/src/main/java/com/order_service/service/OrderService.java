package com.order_service.service;

import com.order_service.dto.OrderRequestDto;
import com.order_service.dto.OrderResponseDto;

public interface OrderService {
	
	OrderResponseDto createOrder(OrderRequestDto dto);

}
