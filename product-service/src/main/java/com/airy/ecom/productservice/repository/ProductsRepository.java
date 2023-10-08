package com.airy.ecom.productservice.repository;

import java.util.List;
import java.util.Optional;

import com.airy.ecom.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product, Integer> {
	
	public Optional<Product> findByProductName(String productName);
	
	public Page<Product> findByCategory(String categoryName, Pageable pageable);
}
