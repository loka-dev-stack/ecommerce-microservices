package com.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order_service.dto.UserResponseDto;

@FeignClient(name="User-service1")
public interface UserClient {
	
    @GetMapping("/api/users/{id}")
    UserResponseDto getUserById(@PathVariable Long id);

	

}
