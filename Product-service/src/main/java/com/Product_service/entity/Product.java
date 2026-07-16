package com.Product_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name="products")
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Id;
	 @Column(nullable = false)
	    private String name;

	    private String description;

	    @Column(nullable = false)
	    private BigDecimal price;

	    @Column(nullable = false)
	    private Integer stock;

	    private String category;

		public Product(Long Id, String name, String description, BigDecimal price, Integer stock,
				String category) {
			super();
			this.Id = Id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.stock = stock;
			this.category = category;
		}

		public Product() {
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long pId) {
			this.Id = Id;
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


	

}
