package com.inventory_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory_service.dto.InventoryRequestDto;
import com.inventory_service.dto.InventoryResponseDto;
import com.inventory_service.service.InventoryService;

import jakarta.validation.Valid;

@RequestMapping("/api/inventory")
@RestController
public class InventoryController {
    @Autowired 
	private InventoryService inventoryService;
    
    @PostMapping("/create")
    public ResponseEntity<InventoryResponseDto> createInventory(@Valid @RequestBody InventoryRequestDto dto){
    	InventoryResponseDto response = inventoryService.createInventory(dto);
    	return ResponseEntity.ok(response);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<InventoryResponseDto>> getAllInventory(){
    	List<InventoryResponseDto> list = inventoryService.getAllInventory();
    	return ResponseEntity.ok(list);
    }
    @GetMapping("/{InventoryId}")
    public ResponseEntity<InventoryResponseDto> findById(@PathVariable Long InventoryId){
		return ResponseEntity.ok(inventoryService.getInventoryById(InventoryId));
    	
    }
    
    @DeleteMapping("/{InventoryID}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long InventoryID){
		return ResponseEntity.ok(inventoryService.deleteInventory(InventoryID));
    	
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<InventoryResponseDto> updateInventory(@PathVariable Long id,@Valid @RequestBody InventoryRequestDto dto){
    	return ResponseEntity.ok(inventoryService.updateInventory(id, dto));
    	
    }
}
