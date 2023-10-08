package com.airy.ecom.productservice.services;

import java.util.List;

import com.airy.ecom.productservice.exception.ProductNotFoundException;
import com.airy.ecom.productservice.model.dto.ProductReqRes;
import com.airy.ecom.productservice.repository.ProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.airy.ecom.productservice.model.Product;

@Service
public class ProductsService {
	
	@Autowired
	private final ProductsRepository productsRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductsService.class);

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	
	//returns all the products listed
	@Cacheable("products-cache")
	public List<ProductReqRes> getAllProducts(int Page, int limit){

		Pageable pageable = PageRequest.of(Page, limit);
		Page<Product> page = productsRepository.findAll(pageable);

		if(page.isEmpty() || page.equals(null)){
			throw new ProductNotFoundException("No Products Found.");
		}
		List<ProductReqRes> products = page.getContent().stream()
														.map(ProductReqRes::new)
														.toList();
		 return products;
	}
	
	//adds Product on Sell Listing
	public void addProducts(ProductReqRes productReqRes) {
		logger.info("Adding Product : "+productReqRes.toString());
		productsRepository.save(mapToProduct(productReqRes));
	}
	

	public ProductReqRes getProductByName(String productName){
		return productsRepository.findByProductName(productName).map(ProductReqRes::new)
				.orElseThrow(() -> new ProductNotFoundException("No Product Found with Name "+productName));
	}

	public List<ProductReqRes> getProductsByCategory(String category, int page, int Limit) {

		Pageable pageable = PageRequest.of(page, Limit);
		Page<Product> productListPage = productsRepository
				.findByCategory(category, pageable);

		if (productListPage.isEmpty() || productListPage.equals(null)){
			throw new ProductNotFoundException("No Product Found for Category "+category);
		}

		return productListPage
				.getContent()
				.stream().map(ProductReqRes::new)
				.toList();
	}

	@Cacheable("products-cache")
	public List<ProductReqRes> fullTextSearch(String searchPhrase) {

		mongoTemplate.indexOps(Product.class)
				.ensureIndex(new TextIndexDefinition.TextIndexDefinitionBuilder().onFields( "product_name","product_description","product_attributes.attribute_value").build());

		TextCriteria textCriteria = TextCriteria
				.forDefaultLanguage()
				.caseSensitive(false)
				.matchingPhrase(searchPhrase);

		Query query = TextQuery.queryText(textCriteria)
				.sortByScore();

		List<ProductReqRes> list =  mongoTemplate.find(query, Product.class).stream().map(ProductReqRes::new).toList();
		if(list.isEmpty() || list.equals(null)){
			throw new ProductNotFoundException("No Result Found for Search "+searchPhrase);
		}
		return list;
	}

	
	public Product mapToProduct(ProductReqRes productReqRes) {
		Product product = new Product();		
		product.setProductName(productReqRes.getProductName());
		product.setImageUrl(productReqRes.getImageUrl());
		product.setDesc(productReqRes.getDesc());
		product.setPrice(productReqRes.getPrice());
		product.setCategory(productReqRes.getCategory());
		product.setAttributes(productReqRes.getAttributes());
		return product;
	}

}
