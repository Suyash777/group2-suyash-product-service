package com.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prod.dto.ProductVariantDto;
import com.prod.entities.ProductVariant;
import com.prod.services.ProductVariantService;

@RestController
@RequestMapping("/api/productVariant")
public class ProductVariantController {
	
	@Autowired
	private ProductVariantService productVariantService;

	public ProductVariantController(ProductVariantService productVariantService) {
		super();
		this.productVariantService = productVariantService;
	}
	
	
	@GetMapping("/{productVariantKey}")
	public ResponseEntity<ProductVariantDto> getProductVariantByKey(@PathVariable String productVariantKey) {
		ProductVariantDto productVariantDto = productVariantService.getProductVariantByKey(productVariantKey);
		return ResponseEntity.ok(productVariantDto);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductVariant>> getAllProductVariant() {
		return ResponseEntity.ok(productVariantService.getAllProductVariant());

	}
	
	@PutMapping("/{productVariantKey}")
	public ResponseEntity<ProductVariantDto> updateProductVaraintByKey(@RequestBody ProductVariantDto productVariantDto,
														@PathVariable String productVariantKey) {
		ProductVariantDto updateProductVariantDto = productVariantService.updateProductVariantByKey(productVariantDto,productVariantKey);
		if (updateProductVariantDto != null) {
	        return new ResponseEntity<>(updateProductVariantDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

}
