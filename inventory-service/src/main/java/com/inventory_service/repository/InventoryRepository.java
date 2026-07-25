package com.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory_service.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
