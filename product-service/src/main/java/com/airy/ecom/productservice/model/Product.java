package com.airy.ecom.productservice.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;


@Document(value = "product_details_table")
@Data @Builder
public class Product {

	//id, name, price, imageurl, desc, category

	@Field(name = "product_id")
	@MongoId
	private String productId;
	
	@Field(name = "product_name")
	@NotNull(message = "Product Name Should Not be Null")
	@TextIndexed(weight = 5)
	private String productName;
	
	@Field(name = "product_image_url")
	@NotNull(message = "Image URL Should Not be Null")
	private List<String> imageUrl;
	
	@Field(name = "product_price")
	private Double price;
	
	@Field(name = "product_description")
	@NotNull(message = "Product Description Should Not be Null")
	@TextIndexed(weight = 4)
	private String desc;
	
	@Field(name = "product_category")
	@NotNull(message = "Category Should Not be Null")
	private String category;

	@Field(name = "product_attributes")
	@TextIndexed(weight = 4)
	@NotNull(message = "Attributes are Mandatory")
	private List<ProductAttributes> attributes;


	//popularity of Product
	//reviews for product


	public Product(String productId, String productName, List<String> imageUrl, double price, String desc,
			String category, List<ProductAttributes> attributes) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.desc = desc;
		this.category = category;
		this.attributes = attributes;
	}
	
	public Product() {
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
