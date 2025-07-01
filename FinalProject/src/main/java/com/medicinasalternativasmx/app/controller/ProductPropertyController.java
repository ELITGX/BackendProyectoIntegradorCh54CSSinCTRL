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

import com.medicinasalternativasmx.app.model.ProductProperty;
import com.medicinasalternativasmx.app.service.ProductPropertyService;



@CrossOrigin
@RestController
@RequestMapping("/api/v1/product_properties")
public class ProductPropertyController {
	
	ProductPropertyService productPropertyService ;


	
	public ProductPropertyController(ProductPropertyService productPropertyService) {
		this.productPropertyService = productPropertyService;
	}


	@GetMapping // ("/api/v1/product_properties") http://localhost:8080/api/v1/product_properties
	 ResponseEntity<Iterable<ProductProperty>> getAllProductProperty(){
			Iterable<ProductProperty> productProperties = productPropertyService.findAll();
			return ResponseEntity.ok(productProperties);		
	}

	
	@PostMapping
	ResponseEntity<ProductProperty> createProductProperty(@RequestBody ProductProperty productProperty ) {
		ProductProperty newProductProperty = productPropertyService.save(productProperty);
		return new ResponseEntity<ProductProperty>(newProductProperty, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteProductProperty(@PathVariable("id") Long id) {
		productPropertyService.deleteById(id);
		return ResponseEntity.noContent().build(); // 204- Sin contenido
	}
	
	@GetMapping("/{id}")
    public ProductProperty getProductPropertyById( @PathVariable("id") Long id )
    {
        return productPropertyService.findById(id);
    }
	
	@PutMapping("/{id}")
	ProductProperty updatedProductProperty(@RequestBody ProductProperty productProperty, @PathVariable("id") Long id) {
		ProductProperty updatedProductProperty = productPropertyService.update(id, productProperty);
		return updatedProductProperty;
	}
	
	@GetMapping("products/{id}")
	public Set<String> getProductsWithSpecificProductPropertyId ( @PathVariable("id") Long id )
    {
        return productPropertyService.getProductsWithSpecificProductPropertyId(id);
    }
	
	
}
