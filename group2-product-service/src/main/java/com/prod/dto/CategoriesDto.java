package com.prod.dto;



public class CategoriesDto {

	private String categoryName;
	private String categoryKey;
	private String description;

	
	public CategoriesDto() {
		super();
	}

	public CategoriesDto(String categoryName,String categoryKey, String description) {
		super();
		this.categoryName = categoryName;
		this.categoryKey = categoryKey;
		this.description = description;
	}


	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
