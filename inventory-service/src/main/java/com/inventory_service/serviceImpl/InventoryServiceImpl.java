package com.inventory_service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory_service.dto.InventoryRequestDto;
import com.inventory_service.dto.InventoryResponseDto;
import com.inventory_service.entity.Inventory;
import com.inventory_service.exception.InventoryNotFoundException;
import com.inventory_service.repository.InventoryRepository;
import com.inventory_service.service.InventoryService;
@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryRepository repo;
	private static final Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);
	@Override
	public InventoryResponseDto createInventory(InventoryRequestDto requestDto) {
		log.info("Creating inventory for product {}", requestDto.getProductId());
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
		log.info("Fetching All The Inventory Details: ");
		List<Inventory> inventoryList = repo.findAll();
		
		return inventoryList.stream().map(this::mapToResponse).toList();
	}

	@Override
	public InventoryResponseDto getInventoryById(Long inventoryId) {
		log.info("Fetching inventory with id: {}", inventoryId);
		Inventory inventory = repo.findById(inventoryId).orElseThrow(()->new InventoryNotFoundException("Inventory Not found with "+inventoryId));
		return mapToResponse(inventory);
		
	}

	@Override
	public String deleteInventory(Long inventoryId) {
		log.info("Deleting The Inventory Id With :"+inventoryId);
		Inventory inventory = repo.findById(inventoryId).
				orElseThrow(()->new InventoryNotFoundException("Inventory Not found with "+inventoryId));
		
		repo.delete(inventory);
		

		return "inventory id deleted "+inventoryId;
	}

	@Override
	public InventoryResponseDto updateInventory(Long inventoryId, InventoryRequestDto requestDto) {
		log.info("Update the Inventory By Id"+inventoryId);
		Inventory inventory = repo.findById(inventoryId).orElseThrow(()->new InventoryNotFoundException("inventory id not found"+inventoryId));
		  inventory.setProductId(requestDto.getProductId());
		    inventory.setQuantity(requestDto.getQuantity());
		    inventory.setWarehouseLocation("Bangalore Warehouse");
		Inventory updateinventory = repo.save(inventory);
		return mapToResponse(updateinventory);
	}

	@Override
	public InventoryResponseDto getInventoryByProductId(Long productId) {
		Inventory inventory = repo.findByProductId(productId)
	            .orElseThrow(() ->
	                    new InventoryNotFoundException(
	                            "Inventory not found for product id: " + productId));

		return mapToResponse(inventory);
	}

	@Override
	public InventoryResponseDto reduceStock(Long productId, Integer quantity) {
		Inventory inventory = repo.findByProductId(productId)
	            .orElseThrow(() ->
	                    new InventoryNotFoundException(
	                            "Inventory not found for product id: " + productId));

	    if (inventory.getQuantity() < quantity) {
	        throw new RuntimeException("Insufficient stock available");
	    }

	    inventory.setQuantity(inventory.getQuantity() - quantity);

	    Inventory updatedInventory = repo.save(inventory);

	    return mapToResponse(updatedInventory);
	}
	
	

}
