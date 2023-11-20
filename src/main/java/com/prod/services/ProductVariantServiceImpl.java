package com.prod.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prod.dto.ProductVariantDto;
import com.prod.entities.ProductVariant;
import com.prod.repositories.ProductVariantRepository;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

	@Autowired
	private ProductVariantRepository productVariantRepo;
	@Autowired
	private ModelMapper modelMapper;

	public ProductVariantServiceImpl(ProductVariantRepository productVariantRepo, ModelMapper modelMapper) {
		super();
		this.productVariantRepo = productVariantRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductVariantDto getProductVariantByKey(String productVariantKey) {
		ProductVariant productVariant = productVariantRepo.findByProductVariantKey(productVariantKey);
		return modelMapper.map(productVariant, ProductVariantDto.class);
	}

	@Override
	public ProductVariantDto updateProductVariantByKey(ProductVariantDto productVariantDto, String productVariantKey) {
		ProductVariant existingProductVariant = productVariantRepo.findByProductVariantKey(productVariantKey);

		if (existingProductVariant != null) {
			existingProductVariant.setSku(productVariantDto.getSku());
			existingProductVariant.setProductVariantKey(productVariantDto.getProductVariantKey());
			existingProductVariant.setPrices(productVariantDto.getPrices());
			existingProductVariant.setAttributes(productVariantDto.getAttributes());
			ProductVariant savedProductVariant = productVariantRepo.save(existingProductVariant);

			return modelMapper.map(savedProductVariant, ProductVariantDto.class);
		}

		return null;
	}

	@Override
	public List<ProductVariant> getAllProductVariant() {
		return productVariantRepo.findAll();
	}

}
