package com.Product_service.cotroller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Product_service.dto.ProductRequestDto;
import com.Product_service.dto.ProductResponseDto;
import com.Product_service.entity.Product;
import com.Product_service.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "Product Management APIs")
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
	
	@Operation(summary = "Get All Products", description = "Returns all available products")
	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
//		return productService.getAllProducts();
		List<ProductResponseDto> response = productService.getAllProducts();

	    return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Get Product By ID")
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
	
	@GetMapping("/page")
	public ResponseEntity<Page<ProductResponseDto>> getAllProducts(
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size,
	        @RequestParam(defaultValue = "id") String sortBy,
	        @RequestParam(defaultValue = "asc") String direction) {

	    Page<ProductResponseDto> products = productService.getAllProducts(page, size,sortBy,direction);

	    return ResponseEntity.ok(products);
	    
//	    http://localhost:8092/api/products/page?page=0&size=5&sortBy=stock&direction=desc
//	    	http://localhost:8092/api/products/page?page=0&size=5&sortBy=price&direction=desc
	}
	@GetMapping("search/category/{category}")
	public ResponseEntity<List<ProductResponseDto>> searchByCategory(@PathVariable String category){
		return ResponseEntity.ok(productService.searchByCategory(category));	
	}
	@GetMapping("search/name/{name}")
	public ResponseEntity<List<ProductResponseDto>> searchByName(@PathVariable String name) {
		return ResponseEntity.ok(productService.searchByName(name));
	}
	@GetMapping("/search/name-price")
	public ResponseEntity<List<ProductResponseDto>> searchByNameAndprice(@RequestParam String name,
			@RequestParam BigDecimal price){
				return ResponseEntity.ok(productService.searchByNameAndPrice(name, price));
		
	}
	@GetMapping("search/price/less-than")
	public ResponseEntity<List<ProductResponseDto>> searchByPriceLessThan(@RequestParam BigDecimal price){
		return ResponseEntity.ok(productService.searchByPriceLessThan(price));
	}
	@GetMapping("search/price/range")
	public ResponseEntity<List<ProductResponseDto>> searchByPriceRange(@RequestParam BigDecimal minPrice,
			@RequestParam BigDecimal maxPrice){
		return ResponseEntity.ok(productService.searchByPriceRange(minPrice, maxPrice));
	}
	@GetMapping("search/contains")
	public ResponseEntity<List<ProductResponseDto>> searchByNamecontaining(@RequestParam String keyword){
		return ResponseEntity.ok(productService.searchByNameContaining(keyword));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}