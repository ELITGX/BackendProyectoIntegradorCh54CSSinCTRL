package com.medicinasalternativasmx.app.service;

import java.util.Set;
import com.medicinasalternativasmx.app.model.Category;


public interface CategoryService  {
	
	Iterable<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    
    void deleteById(Long id);
  
    Set<String> getProductsWithSpecificCategoryId(Long id);
}
