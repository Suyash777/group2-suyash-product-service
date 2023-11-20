package com.prod.dto;

import java.util.Set;

import com.prod.entities.Categories;
import com.prod.entities.ProductVariant;



public class ProductDto {

	private String productKey;
	private String productName;
	private String productDescription;
	private Set<Categories> categories;
	private String productTypeKey;
	private ProductVariant masterVariant;
	private Set<ProductVariant> variants;
	
	
	public ProductDto() {
		super();
	}


	public ProductDto(String productKey, String productName, String productDescription, Set<Categories> categories,
			String productTypeKey, ProductVariant masterVariant, Set<ProductVariant> variants) {
		super();
		this.productKey = productKey;
		this.productName = productName;
		this.productDescription = productDescription;
		this.categories = categories;
		this.productTypeKey = productTypeKey;
		this.masterVariant = masterVariant;
		this.variants = variants;
	}








	public ProductVariant getMasterVariant() {
		return masterVariant;
	}




	public void setMasterVariant(ProductVariant masterVariant) {
		this.masterVariant = masterVariant;
	}




	public Set<ProductVariant> getVariants() {
		return variants;
	}




	public void setVariants(Set<ProductVariant> variants) {
		this.variants = variants;
	}




	public String getProductKey() {
		return productKey;
	}



	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Set<Categories> getCategories() {
		return categories;
	}


	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}


	public String getProductTypeKey() {
		return productTypeKey;
	}



	public void setProductTypeKey(String productTypeKey) {
		this.productTypeKey = productTypeKey;
	}


	
	
}
