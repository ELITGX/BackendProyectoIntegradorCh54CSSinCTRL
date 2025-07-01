package com.medicinasalternativasmx.app.service.Impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.medicinasalternativasmx.app.model.Product;
import com.medicinasalternativasmx.app.model.ProductProperty;
import com.medicinasalternativasmx.app.repository.ProductPropertyRepository;
import com.medicinasalternativasmx.app.service.ProductPropertyService;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService{

private final ProductPropertyRepository productPropertyRepository;
	
	
	public ProductPropertyServiceImpl(ProductPropertyRepository productPropertyRepository) {
	this.productPropertyRepository = productPropertyRepository;
}


	@Override
	public Iterable<ProductProperty> findAll() {
		return productPropertyRepository.findAll();
	}


	@Override
	public ProductProperty findById(Long id) {
	
		Optional<ProductProperty> productPropertyOpt = productPropertyRepository.findById(id);
		if( productPropertyOpt.isEmpty() ) { // no hay objeto, la variable contiene null
			throw new IllegalStateException("ProductProperty does not exist with id " + id);
		}
		
		ProductProperty existingProductProperty = productPropertyOpt.get();
		return existingProductProperty;
	}

	
	@Override
	public void deleteById(Long id) {
		ProductProperty existingProductProperty = findById(id);
		productPropertyRepository.delete(existingProductProperty);		
	}


	@Override
	public ProductProperty save(ProductProperty productProperty) {
		productProperty.setId(null);
		ProductProperty newProductProperty = productPropertyRepository.save(productProperty);
		return newProductProperty;
	}

	@Override
	public ProductProperty update(Long id, ProductProperty productProperty) {
		ProductProperty existingProductProperty = findById(id);
		existingProductProperty.setPresentation( productProperty.getPresentation() );
		existingProductProperty.setConcentration( productProperty.getConcentration() );
		existingProductProperty.setDescription( productProperty.getDescription() );
		existingProductProperty.setAdministration( productProperty.getAdministration() );
		existingProductProperty.setPrecautions( productProperty.getPrecautions() );
		existingProductProperty.setOrigin( productProperty.getOrigin() );
		existingProductProperty.setExpirationDate( productProperty.getExpirationDate() );
		existingProductProperty.setStorage( productProperty.getStorage() );
		
		ProductProperty updatedProductProperty = productPropertyRepository.save( existingProductProperty );
		return updatedProductProperty;
	}

	@Override
	public Set<String> getProductsWithSpecificProductPropertyId(Long id) {
		Optional <ProductProperty> productPropertyOpt = productPropertyRepository.findById(id);
		if(productPropertyOpt.isPresent()) {
			ProductProperty productProperty = productPropertyOpt.get();
			Set<Product> products = productProperty.getProducts();
			if (products == null) {
			    products = new HashSet<>();
			}
			
			Set<String> productWithSpecificProductProperty = new HashSet<String>(); 
			
			for (Product product : products) {
				productWithSpecificProductProperty.add(product.getName());
			}
			
			return productWithSpecificProductProperty;
		}
		
		
		return null;

	}

	
}
