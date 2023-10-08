package com.airy.ecom.productservice.controller;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.airy.ecom.productservice.model.dto.ProductReqRes;
import com.airy.ecom.productservice.services.ProductsService;

@RequestMapping("api/v1/product")
@RestController
public class ProductsController {
	
	/*
	 * This is a Product Service Controller which Provides Following Endpoints
	 */
	
	  // "/api/v1/product/products" - get a list of Products to show on listing Screen
	  // "/api/v1/product/add-product" - to add product to 
	  // "/api/v1/product/{product_name}" - get a single product details of name product_name
	  // "/api/v1/product/{category_name}" - get all products of category_name category
	
	@Autowired
	private final ProductsService productsService;
	
	
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	 
	
	@GetMapping("/products")
	public List<ProductReqRes> listAllProducts(@RequestParam(value = "Page", defaultValue = "0") int Page,
											   @RequestParam(value = "limit", defaultValue = "10") int limit) {
		//returns List of Products Fetched from db
		return productsService.getAllProducts(Page, limit);
	}
	
	@PostMapping("/add-product")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addProducts(@Valid @RequestBody ProductReqRes productReqRes){
		productsService.addProducts(productReqRes);
		return ResponseEntity.ok("Product Added with Name "+productReqRes.getProductName());
	}
	
	@GetMapping("/{productName}")
	public ProductReqRes getProductByName(@PathVariable String productName) {
		return productsService.getProductByName(productName);
	}

	@GetMapping("/search")
	public List<ProductReqRes> searchProducts(@NotBlank(message = "Enter Search Term") @RequestParam String criteriaPhrase) {
		return productsService.fullTextSearch(criteriaPhrase);
	}
	
	@GetMapping("/category/{category}")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductReqRes> getProductsByCategory(@PathVariable String category
			, @RequestParam(value = "page", defaultValue = "0") int Page
			, @RequestParam(value = "limit", defaultValue = "10") int limit){
		return productsService.getProductsByCategory(category, Page, limit);
	}
	
	
}
