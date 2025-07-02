package com.medicinasalternativasmx.app.service.Impl;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
//import com.medicinasalternativasmx.app.model.Role;
//import com.medicinasalternativasmx.app.model.User;
//import com.medicinasalternativasmx.app.repository.RoleRepository;
//import com.medicinasalternativasmx.app.service.RoleService;

import com.medicinasalternativasmx.app.model.Category;
import com.medicinasalternativasmx.app.model.Product;
import com.medicinasalternativasmx.app.repository.CategoryRepository;
import com.medicinasalternativasmx.app.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	@Override
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	
	@Override
	public Category findById(Long id) {
	
		Optional<Category> categoryOpt = categoryRepository.findById(id);
		if( categoryOpt.isEmpty() ) { 
			throw new IllegalStateException("Category does not exist with id " + id);
		}
		Category existingCategory = categoryOpt.get();
		return existingCategory;
	}

	
	@Override
	public Category save(Category category) {
		category.setId(null);
		Category newCategory = categoryRepository.save(category);
		return newCategory;
	}
	
	
	@Override
	public Category update(Long id, Category category) {
		Category existingCategory = findById(id);
		
		existingCategory.setName( category.getName() );
		existingCategory.setDescription( category.getDescription() );
	
		Category updatedCategory = categoryRepository.save( existingCategory );
		return updatedCategory;
	}
	
	@Override
	public void deleteById(Long id) {
		Category existingCategory = findById(id);
		categoryRepository.delete(existingCategory);		
	}

	@Override
	public Set<String> getProductsWithSpecificCategoryId(Long id) {
		Optional <Category> categoryOpt = categoryRepository.findById(id);
		if(categoryOpt.isPresent()) {
			Category category = categoryOpt.get();
			Set<Product> products = category.getProducts();
			
			Set<String> productWithSpecificCategory = new HashSet<String>(); 
			
			for (Product product : products) {
				productWithSpecificCategory.add(product.getName());
			}
			
			return productWithSpecificCategory;
		}
		
		
		return null;
	}

}
