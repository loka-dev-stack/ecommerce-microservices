package com.payment_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payment_service.dto.OrderResponseDto;

@FeignClient("order-service")
public interface OrderClient {
	

    @GetMapping("/api/orders/{orderId}")
    OrderResponseDto getOrderById(@PathVariable Long orderId);


}
