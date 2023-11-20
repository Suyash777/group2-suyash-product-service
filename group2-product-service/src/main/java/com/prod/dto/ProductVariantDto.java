package com.prod.dto;

import java.util.Map;
import java.util.Set;

import com.prod.entities.Price;


public class ProductVariantDto {

	private String sku;
	private Set<Price> prices;
	private Map<String, String> attributes;
	
	
	public ProductVariantDto() {
		super();
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public Set<Price> getPrices() {
		return prices;
	}


	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}


	public Map<String, String> getAttributes() {
		return attributes;
	}


	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}


	public ProductVariantDto(String sku, Set<Price> prices, Map<String, String> attributes) {
		super();
		this.sku = sku;
		this.prices = prices;
		this.attributes = attributes;
	}
	
	

}
