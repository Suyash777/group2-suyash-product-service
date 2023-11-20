package com.prod.services;

import java.util.List;

import com.prod.dto.ProductVariantDto;
import com.prod.entities.ProductVariant;


public interface ProductVariantService {

	
	ProductVariantDto getProductVariantByKey(String productVariantKey);
	List<ProductVariant> getAllProductVariant();
	ProductVariantDto updateProductVariantByKey(ProductVariantDto productVariantDto, String productVariantKey);
}
