package com.inventory_service.dto;

public class InventoryResponseDto {
	
	 private Long inventoryId;
	    private Long productId;
	    private Integer quantity;
	    private String warehouseLocation;
		public Long getInventoryId() {
			return inventoryId;
		}
		public void setInventoryId(Long inventoryId) {
			this.inventoryId = inventoryId;
		}
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
		public String getWarehouseLocation() {
			return warehouseLocation;
		}
		public void setWarehouseLocation(String warehouseLocation) {
			this.warehouseLocation = warehouseLocation;
		}
		@Override
		public String toString() {
			return "InventoryResponseDto [inventoryId=" + inventoryId + ", productId=" + productId + ", quantity="
					+ quantity + ", warehouseLocation=" + warehouseLocation + "]";
		}
		
		
	    
	    

}
