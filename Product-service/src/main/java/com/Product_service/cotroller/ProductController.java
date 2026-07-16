package com.Product_service.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Product_service.dto.ProductRequestDto;
import com.Product_service.dto.ProductResponseDto;
import com.Product_service.entity.Product;
import com.Product_service.service.ProductService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponseDto> createdto(@Valid @RequestBody ProductRequestDto dto) {
//		
//		System.out.println("record is saved");
//		return productService.createProduct(dto) ;
			
			System.out.println("record is saved");
			ProductResponseDto response = productService.createProduct(dto) ;
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
//		return productService.getAllProducts();
		List<ProductResponseDto> response = productService.getAllProducts();

	    return ResponseEntity.ok(response);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> getproductById(@PathVariable Long id) {
//		return productService.getProductById(id);
		ProductResponseDto response = productService.getProductById(id);

	    return ResponseEntity.ok(response);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
//		productService.deleteProduct(id);
//		return "record deleted " ;		
		 productService.deleteProduct(id);

		    return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateById(@PathVariable Long id ,@Valid
			@RequestBody ProductRequestDto dto) {
//		return productService.getUpdateById(id, dto);
		ProductResponseDto response = productService.getUpdateById(id, dto);

	    return ResponseEntity.ok(response);
	
		
	}

}
