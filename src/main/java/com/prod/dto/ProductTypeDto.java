package com.prod.dto;

import java.util.Map;



public class ProductTypeDto {

	private String productTypeName;
	private String productTypekey;
	private Map<String,String> attributeDefination;
	
	
	
	public ProductTypeDto() {
		super();
	}



	public ProductTypeDto(String productTypeName, String productTypekey,
			Map<String, String> attributeDefination) {
		super();
		this.productTypeName = productTypeName;
		this.productTypekey = productTypekey;
		this.attributeDefination = attributeDefination;
	}



	
	public String getProductTypeName() {
		return productTypeName;
	}



	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}



	public String getProductTypekey() {
		return productTypekey;
	}



	public void setProductTypekey(String productTypekey) {
		this.productTypekey = productTypekey;
	}



	public Map<String, String> getAttributeDefination() {
		return attributeDefination;
	}



	public void setAttributeDefination(Map<String, String> attributeDefination) {
		this.attributeDefination = attributeDefination;
	}
	
	
}
