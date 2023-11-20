package com.prod.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.dto.ProductTypeDto;
import com.prod.entities.ProductType;
import com.prod.services.ProductTypeService;

@RestController
@RequestMapping("/api/productType")
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	public ProductTypeController(ProductTypeService productTypeService) {
		super();
		this.productTypeService = productTypeService;
	}

	@PostMapping
	public ResponseEntity<ProductTypeDto> saveProductTypeDto(@RequestBody ProductTypeDto productTypeDto) {
		ProductTypeDto savedProductTypeDto = productTypeService.saveProductType(productTypeDto);
		return new ResponseEntity<>(savedProductTypeDto, HttpStatus.CREATED);
	}

	@GetMapping("/{productTypeKey}")
	public ResponseEntity<ProductTypeDto> getProductTypeByKey(@PathVariable("productTypeKey") String productTypeKey) {
		ProductTypeDto productTypeDto = productTypeService.getProductTypeByKey(productTypeKey);
		return ResponseEntity.ok(productTypeDto);
	}

	@GetMapping
	public ResponseEntity<List<ProductType>> getAllProductType() {
		return ResponseEntity.ok(productTypeService.getAllProductType());

	}

	@DeleteMapping("/{productTypeKey}")
	public ResponseEntity<ProductType> deleteProductTypeByKey(@PathVariable("productTypeKey") String productTypeKey) {
		ProductType productType = productTypeService.deleteProductTypeByKey(productTypeKey);
		return ResponseEntity.ok(productType);
	}
	
	@PutMapping("/{productTypeKey}")
	public ResponseEntity<ProductTypeDto> updateProductTypeByKey(@RequestBody ProductTypeDto productTypeDto,
														@PathVariable("productTypeKey") String productTypeKey) {
		ProductTypeDto updateProductTypeDto = productTypeService.updateProductTypeByKey(productTypeDto,productTypeKey);
		if (updateProductTypeDto != null) {
	        return new ResponseEntity<>(updateProductTypeDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	

}
