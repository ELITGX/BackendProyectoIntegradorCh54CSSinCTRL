package com.medicinasalternativasmx.app.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicinasalternativasmx.app.model.Category;
import com.medicinasalternativasmx.app.service.CategoryService;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	CategoryService categoryService ;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping // ("/api/v1/categories") http://localhost:8080/api/v1/categories
	 ResponseEntity<Iterable<Category>> getAllCategories(){
			Iterable<Category> categories = categoryService.findAll();
			return ResponseEntity.ok(categories);		
	}

	
	@PostMapping
	ResponseEntity<Category> createCategory(@RequestBody Category category ) {
		Category newCategory = categoryService.save(category);
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteById(id);
		return ResponseEntity.noContent().build(); // 204- Sin contenido
	}
	
	@GetMapping("/{id}")
    public Category getCategoryById( @PathVariable("id") Long id )
    {
        return categoryService.findById(id);
    }
	
	@PutMapping("/{id}")
	Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
		Category updatedCategory = categoryService.update(id, category);
		return updatedCategory;
	}
	
	@GetMapping("categories/{id}")
	public Set<String> getProductsWithSpecificCategoryId ( @PathVariable("id") Long id )
    {
        return categoryService.getProductsWithSpecificCategoryId(id);
    }
	
	
}