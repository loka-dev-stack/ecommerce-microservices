package com.Product_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name="products")
public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="product_id")
	    private Long productId;
	    @Column(nullable=false,length=150)
	    private String name;
	    @Column(nullable = false, length = 500)
	    private String description;

	    @Column(nullable=false, precision=10, scale=2)
	    private BigDecimal price;

	    @Column(nullable = false)
	    private Integer stock;
	    @Column(nullable = false, length = 500)
	    private String category;

		
		public Product() {
			// TODO Auto-generated constructor stub
		}


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


		public Integer getStock() {
			return stock;
		}


		public void setStock(Integer stock) {
			this.stock = stock;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
					+ price + ", stock=" + stock + ", category=" + category + "]";
		}

		

	

}
