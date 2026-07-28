package com.Product_service.dto;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;


public class ProductRequestDto {

	
	@NotBlank(message = "Product name is required")
    private String name;
    @NotBlank(message = "Description is required ")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private BigDecimal price;
    
    @NotBlank(message = "catagory is required")
    private String category;
    
    public ProductRequestDto() {
    	
    }

	 public ProductRequestDto(String name,
		            String description,
		            BigDecimal price,
		            String category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
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
    
    
	
}
