package com.medicinasalternativasmx.app.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
// import org.springframework.core.annotation.*;
import org.springframework.stereotype.*;
import com.medicinasalternativasmx.app.repository.CategoryRepository;


@Component
@Profile("h2")
// @Order(1)
public class CategoryDataLoader implements CommandLineRunner{

	CategoryRepository categoryRepository; 
	
	public CategoryDataLoader(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}