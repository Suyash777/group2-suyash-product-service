package com.prod.services;

import java.util.List;

import com.prod.dto.ProductDto;
import com.prod.entities.Product;

public interface ProductService {

	ProductDto saveProduct(ProductDto productDto);
	ProductDto getProductByKey(String productKey);
	List<Product> getAllProduct();
	ProductDto updateProductByKey(ProductDto productDto, String productKey);
	Product deleteProductByKey(String productKey);
}
