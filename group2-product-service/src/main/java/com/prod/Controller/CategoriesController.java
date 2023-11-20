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

import com.prod.dto.CategoriesDto;
import com.prod.entities.Categories;
import com.prod.services.CategoriesService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	
	@Autowired
	private CategoriesService categoriesService;

	public CategoriesController(CategoriesService categoriesService) {
		super();
		this.categoriesService = categoriesService;
	}
	
	@PostMapping
	public ResponseEntity<CategoriesDto> saveCategoriesDto(@RequestBody CategoriesDto categoriesDto){
		CategoriesDto savedCategoriesDto = categoriesService.saveCategory(categoriesDto);
        return new ResponseEntity<>(savedCategoriesDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/{categoryKey}")
    public ResponseEntity<CategoriesDto> getCategoryByKey(@PathVariable("categoryKey") String categoryKey){
		CategoriesDto categoriesDto = categoriesService.getCategoryByKey(categoryKey);
         return ResponseEntity.ok(categoriesDto);
    }
	
	@GetMapping
	public ResponseEntity<List<Categories>> getAllCategories() {
		return ResponseEntity.ok(categoriesService.getAllCategories());
	}
	
	@DeleteMapping("/{categoryKey}")
	public ResponseEntity<Categories> deleteCategoriesByKey(@PathVariable("categoryKey") String categoryKey) {
		Categories category = categoriesService.deleteCategoriesByKey(categoryKey);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/{categoriesKey}")
	public ResponseEntity<CategoriesDto> updateCategoriesByKey(@RequestBody CategoriesDto categoriesDto,
														@PathVariable("categoriesKey") String categoriesKey) {
		CategoriesDto updateCategoriesDto = categoriesService.updateCategoriesByKey(categoriesDto,categoriesKey);
		if (updateCategoriesDto != null) {
	        return new ResponseEntity<>(updateCategoriesDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
