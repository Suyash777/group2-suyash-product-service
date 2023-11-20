package com.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.dto.ProductDto;
import com.prod.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> saveProductDto(@RequestBody ProductDto productDto){
		ProductDto savedProductDto = productService.saveProduct(productDto);
        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/{productKey}")
    public ResponseEntity<ProductDto> getProductByKey(@PathVariable("productKey") String productKey){
		ProductDto productDto = productService.getProductByKey(productKey);
         return ResponseEntity.ok(productDto);
    }
}
