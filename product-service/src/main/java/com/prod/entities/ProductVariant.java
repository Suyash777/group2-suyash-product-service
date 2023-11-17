package com.prod.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany; 

@Entity
public class ProductVariant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String sku;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Price> prices;

	

	public ProductVariant(String sku, Set<Price> prices) {
		super();
		this.sku = sku;
		this.prices = prices;
	}

	public ProductVariant() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku; 
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	public void setSku(String sku) { 
		this.sku = sku;
	}
	
	

}