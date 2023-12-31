package com.prod.services;

import java.util.List;

import com.prod.dto.CategoriesDto;
import com.prod.entities.Categories;

public interface CategoriesService {

	CategoriesDto saveCategory(CategoriesDto categoriesDto);
	CategoriesDto getCategoryByKey(String categoryKey);
	List<Categories> getAllCategories();
	Categories deleteCategoriesByKey(String categoryKey);
	CategoriesDto updateCategoriesByKey(CategoriesDto categoriesDto, String categoriesKey);
	
}
