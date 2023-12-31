package com.prod.services;

import java.util.List;

import com.prod.dto.ProductTypeDto;
import com.prod.entities.ProductType;

public interface ProductTypeService {
	ProductTypeDto saveProductType(ProductTypeDto productTypeDto);
	ProductTypeDto getProductTypeByKey(String productTypeKey);
	List<ProductType> getAllProductType();
	ProductType deleteProductTypeByKey(String productTypeKey);
	ProductTypeDto updateProductTypeByKey(ProductTypeDto productTypeDto, String productTypeKey);
}
