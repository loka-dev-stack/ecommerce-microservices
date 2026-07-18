package com.Product_service.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Product_service.Exception.ProductNotFoundException;
import com.Product_service.dto.ProductRequestDto;
import com.Product_service.dto.ProductResponseDto;
import com.Product_service.entity.Product;
import com.Product_service.repository.ProductRepository;
import com.Product_service.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;




@Service
public class ServiceImpl implements ProductService{
	
	private static final Logger log =
            LoggerFactory.getLogger(ServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;
	@Override
	public ProductResponseDto createProduct(ProductRequestDto dto) {
		
		log.info("Creating new product with name: {}", dto.getName());
		Product product = mapToEntity(dto);
		Product saveproduct = productRepository.save(product);
	    log.info("Product created successfully. ID: {}", saveproduct.getId());

		return mapToDto(saveproduct);
		
//		Product product = new Product();
//		product.setName(dto.getName());
//		product.setDescription(dto.getDescription());
//		product.setPrice(dto.getPrice());
//		
//		product.setStock(dto.getStock());
//		product.setCategory(dto.getCategory());
//		
//		 Product save = productRepository.save(product);
//		 
//		 ProductResponseDto response = new ProductResponseDto();
//		 response.setId(save.getId());
//		 response.setName(save.getName());
//		 response.setDescription(save.getDescription());
//		 response.setPrice(save.getPrice());
//		 response.setStock(save.getStock());
//		 response.setCategory(save.getCategory());
	}
	@Override
	public List<ProductResponseDto> getAllProducts() {
		log.info("Fetching all products");
		List<Product> products = productRepository.findAll();
		
		List<ProductResponseDto> responselist = new ArrayList<>();
		log.info("Total products found: {}", products.size());
		
		for (Product product : products) {
			responselist.add(mapToDto(product));
		}

		return responselist;
		
	}
	@Override
	public ProductResponseDto getProductById(Long id) {
		
		log.info("Fetching product with ID: {}", id);
		
		Product product = productRepository.findById(id)
	            .orElseThrow(() -> {
	                log.warn("Product not found with ID: {}", id);
	                return new ProductNotFoundException("Product not found with ID: " + id);
	            });
		
	    log.info("Product found with ID: {}", id);
		
		 return mapToDto(product);
		
	}
	@Override
	public void deleteProduct(Long id) {
		log.info("Deleting product with ID: {}", id);
		Product product =productRepository.findById(id).
				orElseThrow(()->new ProductNotFoundException("product not found"+ id));
		
		productRepository.delete(product);
		log.info("Product deleted successfully with ID: {}", id);
	}
	@Override
	public ProductResponseDto getUpdateById(Long id, ProductRequestDto dto) {
		 log.info("Updating product with ID: {}", id);
		Product product = productRepository.findById(id).
				orElseThrow(()->{
					log.warn("product not found with Id:{}",id);
				return new ProductNotFoundException("Product not found with ID: "+ id);
				});
		
		
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		product.setCategory(dto.getCategory());
				
		Product updateproduct = productRepository.save(product);
		log.info("Product updated successfully with ID: {}", id);
		return mapToDto(updateproduct);
	}
	
	private Product mapToEntity(ProductRequestDto ex) {
		
		Product product = new Product();
		product.setName(ex.getName());
		product.setCategory(ex.getCategory());
		product.setDescription(ex.getDescription());
		product.setStock(ex.getStock());
		product.setPrice(ex.getPrice());
		
		return product;
		
	}
	
	private ProductResponseDto mapToDto(Product product) {
	
		
	 ProductResponseDto response = new ProductResponseDto();
	 response.setId(product.getId());
	 response.setName(product.getName());
	 response.setCategory(product.getCategory());
	 response.setDescription(product.getDescription());
	 response.setPrice(product.getPrice());
	 response.setStock(product.getStock());
	 return response;	

}
	@Override
	public Page<ProductResponseDto> getAllProducts(int page, int size,String sortBy, String direction) {
		 log.info("Fetching products. Page: {}, Size: {}, Sort By: {}, Direction: {}",
		            page, size, sortBy, direction);
		 
		 Sort sort = direction.equalsIgnoreCase("desc")
		            ? Sort.by(sortBy).descending()
		            : Sort.by(sortBy).ascending();
		
	 Pageable pageable = PageRequest.of(page,size,sort);
//	 Pageable pageable = PageRequest.of(page, size, Sort.by("price").ascending()); for sorting
	 Page<Product> products = productRepository.findAll(pageable);
		return products.map(this::mapToDto);
	}
	@Override
	public List<ProductResponseDto> searchByCategory(String category) {
		return productRepository.findByCategory(category).stream().map(this::mapToDto)
	            .toList();
		
	}
	@Override
	public List<ProductResponseDto> searchByName(String name) {
		return productRepository.findByName(name).stream().map(this::mapToDto).toList();
	}
	@Override
	public List<ProductResponseDto> searchByNameAndPrice(String name, BigDecimal price) {
		List<ProductResponseDto> response = productRepository.findByNameAndPrice(name, price).stream().map(this::mapToDto).toList();
		return response;
	}
	@Override
	public List<ProductResponseDto> searchByPriceLessThan(BigDecimal price) {
		return productRepository.findByPriceLessThan(price).stream().map(this::mapToDto).toList();
	}
	@Override
	public List<ProductResponseDto> searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
		
		return productRepository.findByPriceBetween(minPrice, maxPrice).stream().map(this::mapToDto).toList();
	}
	@Override
	public List<ProductResponseDto> searchByNameContaining(String keyword) {
		
		return productRepository.findByNameContaining(keyword).stream().map(this::mapToDto).toList();
	}
}