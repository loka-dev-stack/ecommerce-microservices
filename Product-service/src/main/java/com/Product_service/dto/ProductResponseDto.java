package com.Product_service.dto;

import java.math.BigDecimal;

public class ProductResponseDto {
	
	 private Long productId;
	    private String name;
	    private String description;
	    private BigDecimal price;
	    private String category;
		
	    
	    public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}
     	public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "ProductResponseDto [productId=" + productId + ", name=" + name + ", description=" + description
					+ ", price=" + price + ", category=" + category + "]";
		}

		public ProductResponseDto() {
	    	
	    }

}
