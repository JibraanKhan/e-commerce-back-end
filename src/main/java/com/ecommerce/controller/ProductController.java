package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@RestController
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	
	@GetMapping("/products/")
	public ResponseEntity<?> getAllProducts() {
		List<Product> products = productService.getAllproducts();
		
		if (products == null || products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found.");
		}
		
		return ResponseEntity.ok(products);
	}
}
