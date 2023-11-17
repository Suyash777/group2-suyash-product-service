package com.prod.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.dto.CategoriesDto;
import com.prod.dto.ProductTypeDto;
import com.prod.entities.Categories;
import com.prod.entities.ProductType;
import com.prod.repositories.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepo;
	@Autowired
	private ModelMapper modelMapper;

	public CategoriesServiceImpl(CategoriesRepository categoriesRepo, ModelMapper modelMapper) {
		super();
		this.categoriesRepo = categoriesRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public CategoriesDto saveCategory(CategoriesDto categoriesDto) {
		Categories categories = modelMapper.map(categoriesDto, Categories.class);
		Categories savedCategories = categoriesRepo.save(categories);
		return modelMapper.map(savedCategories, CategoriesDto.class);
	}

	@Override
	public CategoriesDto getCategoryByKey(String categoryKey) {
		Categories categories = categoriesRepo.findByCategoryKey(categoryKey);

		return modelMapper.map(categories, CategoriesDto.class);
	}

	@Override
	public List<Categories> getAllCategories() {
		return categoriesRepo.findAll();
	}

	@Override
	public Categories deleteCategoriesByKey(String categoryKey) {
		Categories category = categoriesRepo.findByCategoryKey(categoryKey);
		if (category != null) {
			categoriesRepo.delete(category);
			return category;
		} else {
			return null;
		}
	}

	@Override
	public CategoriesDto updateCategoriesByKey(CategoriesDto categoriesDto, String categoriesKey) {
		Categories existingCategories = categoriesRepo.findByCategoryKey(categoriesKey);

		if (existingCategories != null) {
			existingCategories.setCategoryName(categoriesDto.getCategoryName());
			existingCategories.setCategoryKey(categoriesDto.getCategoryKey());
			existingCategories.setDescription(categoriesDto.getDescription());
			Categories savedCategories = categoriesRepo.save(existingCategories);

			return modelMapper.map(savedCategories, CategoriesDto.class);
		}

		return null;
	}

}
