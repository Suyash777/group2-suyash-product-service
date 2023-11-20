package com.prod.services;

import com.prod.dto.ProductDto;

public interface ProductService {

	ProductDto saveProduct(ProductDto productDto);
	ProductDto getProductByKey(String productKey);
}
