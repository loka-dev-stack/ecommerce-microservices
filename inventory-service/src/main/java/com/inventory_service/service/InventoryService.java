package com.inventory_service.service;

import java.util.List;

import com.inventory_service.dto.InventoryRequestDto;
import com.inventory_service.dto.InventoryResponseDto;

public interface InventoryService {
     
	 InventoryResponseDto createInventory(InventoryRequestDto requestDto);

	    List<InventoryResponseDto> getAllInventory();
        InventoryResponseDto getInventoryById(Long inventoryId);
	    InventoryResponseDto updateInventory(Long inventoryId, InventoryRequestDto requestDto);
	    String deleteInventory(Long inventoryId);
}
