package com.inventory_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryRequestDto {
	@NotNull(message="Product id is Required")
	private Long productId;
	@NotNull(message="Quantity is Required")
	 @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "InventoryRequestDto [productId=" + productId + ", quantity=" + quantity + "]";
	}
    
    

}
