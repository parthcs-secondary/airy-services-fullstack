package com.airy.ecom.productservice.model.dto;

import com.airy.ecom.productservice.model.Product;
import com.airy.ecom.productservice.model.ProductAttributes;

import java.io.Serializable;
import java.util.List;

public class ProductReqRes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String productId;
	private String productName;
	private List<String> imageUrl;
	private double price;
	private String desc;
	private String category;
	private List<ProductAttributes> attributes;
	
	
	public ProductReqRes(String productId, String productName, List<String> imageUrl, double price, String desc,
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

	public ProductReqRes(Product product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.imageUrl = product.getImageUrl();
		this.price = product.getPrice();
		this.desc = product.getDesc();
		this.category = product.getCategory();
		this.attributes = product.getAttributes();
	}
	
	public ProductReqRes() {
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ProductAttributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ProductAttributes> attributes) {
		this.attributes = attributes;
	}
}
