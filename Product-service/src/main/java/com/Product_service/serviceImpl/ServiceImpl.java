package com.Product_service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product_service.Exception.ProductNotFoundException;
import com.Product_service.dto.ProductRequestDto;
import com.Product_service.dto.ProductResponseDto;
import com.Product_service.entity.Product;
import com.Product_service.repository.ProductRepository;
import com.Product_service.service.ProductService;
@Service
public class ServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	@Override
	public ProductResponseDto createProduct(ProductRequestDto dto) {
		
		Product product = mapToEntity(dto);
		Product saveproduct = productRepository.save(product);
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
		List<Product> products = productRepository.findAll();
		
		List<ProductResponseDto> responselist = new ArrayList<>();
		
		for (Product product : products) {
			responselist.add(mapToDto(product));
		}
		return responselist;
		
	}
	@Override
	public ProductResponseDto getProductById(Long id) {
		
		Product product = productRepository.findById(id).
				orElseThrow(() ->
			    new ProductNotFoundException ("Product with ID " + id + " not found"));
		
		 return mapToDto(product);
		
	}
	@Override
	public void deleteProduct(Long id) {
		Product product =productRepository.findById(id).
				orElseThrow(()->new ProductNotFoundException("product not found"+ id));
		
		productRepository.delete(product);
	}
	@Override
	public ProductResponseDto getUpdateById(Long id, ProductRequestDto dto) {
		Product product = productRepository.findById(id).
				orElseThrow(()->new ProductNotFoundException("Product with ID " + id + " not found"));
		
		
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		product.setCategory(dto.getCategory());
		
		Product updateproduct = productRepository.save(product);
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
}