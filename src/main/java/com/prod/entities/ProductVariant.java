package com.prod.entities;

import java.util.Map;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;


@Entity
public class ProductVariant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String sku;
	
	@Column(unique = true)
	private String productVariantKey; 
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Price> prices;
	
	
	@ElementCollection
	@CollectionTable(name = "Attributes", joinColumns = {@JoinColumn(name = "product_variant_id", referencedColumnName = "id") })
	@MapKeyColumn(name = "DefinationName")
	@Column(name = "DefinationType")
	private Map<String, String> attributes;
	

	public ProductVariant() {
		super();
	}
	

	public ProductVariant(String sku, String productVariantKey, Set<Price> prices, Map<String, String> attributes) {
		super();
		this.sku = sku;
		this.productVariantKey = productVariantKey;
		this.prices = prices;
		this.attributes = attributes;
	}


	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public String getProductVariantKey() {
		return productVariantKey;
	}


	public void setProductVariantKey(String productVariantKey) {
		this.productVariantKey = productVariantKey;
	}


	public Map<String, String> getAttributes() {
		return attributes;
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
