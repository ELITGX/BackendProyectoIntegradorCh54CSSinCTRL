package com.medicinasalternativasmx.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
// import org.springframework.core.annotation.*;
import org.springframework.stereotype.*;

import com.medicinasalternativasmx.app.model.Product;
import com.medicinasalternativasmx.app.repository.ProductRepository;

@Component
@Profile("h2")
// @Order(1)
public class ProductDataLoader implements CommandLineRunner{

	ProductRepository productRepository; 
	
	public ProductDataLoader(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		productRepository.save(new Product(
				null, "NAC", "N-Acetil Cisteína", 6700.00, "imgUrl", 100));
		
	}

	
}
