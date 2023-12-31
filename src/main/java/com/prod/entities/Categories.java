package com.prod.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique = true,nullable = false)
	private String categoryName;
	@Column(unique = true,nullable = false)
	private String categoryKey;
	@Column(nullable = false)
	private String description;
	
	public Categories() {
		super(); 
	}

	public Categories(String categoryName,String categoryKey, String description) {
		super();
		this.categoryName = categoryName;
		this.categoryKey=categoryKey;
		this.description = description;
	}

	
	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
