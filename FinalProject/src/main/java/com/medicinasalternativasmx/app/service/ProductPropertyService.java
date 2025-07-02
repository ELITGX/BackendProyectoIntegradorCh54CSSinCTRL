package com.medicinasalternativasmx.app.service;

import java.util.Set;

import com.medicinasalternativasmx.app.model.ProductProperty;



public interface ProductPropertyService {
	
	Iterable<ProductProperty> findAll();
   
     ProductProperty findById(Long id);
    
     ProductProperty save(ProductProperty productProperty);
   
     ProductProperty update(Long id, ProductProperty productProperty);
    
    void deleteById(Long id);

	Set<String> getProductsWithSpecificProductPropertyId(Long id);


}
