package com.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.inventory_service.dto.InventoryResponseDto;


@FeignClient(name="inventory-service")
public interface InventoryClient {

	 @GetMapping("/api/inventory/product/{productId}")
	    InventoryResponseDto getInventoryByProductId(@PathVariable Long productId);

	    @PutMapping("/api/inventory/reduce/{productId}/{quantity}")
	    InventoryResponseDto reduceStock(@PathVariable Long productId,
	                                     @PathVariable Integer quantity);
}
