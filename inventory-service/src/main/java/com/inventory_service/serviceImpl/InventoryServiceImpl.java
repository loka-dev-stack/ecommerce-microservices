package com.inventory_service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory_service.dto.InventoryRequestDto;
import com.inventory_service.dto.InventoryResponseDto;
import com.inventory_service.entity.Inventory;
import com.inventory_service.repository.InventoryRepository;
import com.inventory_service.service.InventoryService;
@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository repo;

	@Override
	public InventoryResponseDto createInventory(InventoryRequestDto requestDto) {
		
		Inventory inventory = mapToEntity(requestDto);
		Inventory response = repo.save(inventory);
		
		return mapToResponse(response);
	}
	
	private Inventory mapToEntity(InventoryRequestDto dto) {
		
		Inventory inventory = new Inventory();
		inventory.setProductId(dto.getProductId());
		inventory.setQuantity(dto.getQuantity());
		inventory.setWarehouseLocation("Bangalore Warehouse");
		return inventory;
		
	}
	
	private InventoryResponseDto mapToResponse(Inventory inventory) {
		
		InventoryResponseDto response = new InventoryResponseDto();
		response.setInventoryId(inventory.getInventoryId());
		response.setProductId(inventory.getProductId());
		response.setQuantity(inventory.getQuantity());
		response.setWarehouseLocation(inventory.getWarehouseLocation());
		return response;
	}

	@Override
	public List<InventoryResponseDto> getAllInventory() {
		List<Inventory> inventoryList = repo.findAll();
		
		return inventoryList.stream().map(this::mapToResponse).toList();
	}

	@Override
	public InventoryResponseDto getInventoryById(Long inventoryId) {
		Inventory inventory = repo.findById(inventoryId).orElseThrow(()->new RuntimeException("Inventory Not found with "+inventoryId));
		return mapToResponse(inventory);
		
	}

	@Override
	public String deleteInventory(Long inventoryId) {
		Inventory inventory = repo.findById(inventoryId).
				orElseThrow(()->new RuntimeException("Inventory Not found with "+inventoryId));
		
		repo.delete(inventory);
		

		return "inventory id deleted"+inventory;
	}

	@Override
	public InventoryResponseDto updateInventory(Long inventoryId, InventoryRequestDto requestDto) {
		Inventory inventory = repo.findById(inventoryId).orElseThrow(()->new RuntimeException("inventory id not found"));
		  inventory.setProductId(requestDto.getProductId());
		    inventory.setQuantity(requestDto.getQuantity());
		    inventory.setWarehouseLocation("Bangalore Warehouse");
		Inventory updateinventory = repo.save(inventory);
		return mapToResponse(updateinventory);
	}

}
