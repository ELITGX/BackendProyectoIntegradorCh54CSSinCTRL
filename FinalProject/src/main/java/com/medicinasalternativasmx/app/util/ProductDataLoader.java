package com.medicinasalternativasmx.app.util;


//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

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

		productRepository.save(new Product
			(null, "NAC", "N-Acetil Cisteína", 6700.00, "imgUrl", 100));
		productRepository.save(new Product
			(null, "Manganeso", "Sulfato de manganeso", 380.00, "imgUrl", 100));
		productRepository.save(new Product
			(null, "Vivatiamin", "Pirofosfato de Tiamina", 550.00, "imgUrl", 100));
		productRepository.save(new Product
			(null, "Metilviv", "Azul de metileno", 380.00, "imgUrl", 100));
		productRepository.save(new Product
			(null, "DMSO", "Dimetil Sulfóxico al 99%", 480.00, "imgUrl", 100));
	}

	
}
