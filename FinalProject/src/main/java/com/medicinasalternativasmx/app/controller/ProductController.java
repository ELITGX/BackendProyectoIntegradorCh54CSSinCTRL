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

import com.medicinasalternativasmx.app.model.Product;
import com.medicinasalternativasmx.app.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	ProductService productService ;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping // ("/api/v1/products") http://localhost:8080/api/v1/products
	 ResponseEntity<Iterable<Product>> getAllProducts(){
			Iterable<Product> products = productService.findAll();
			// new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
			return ResponseEntity.ok(products);		
	}

	
	@PostMapping
	ResponseEntity<Product> createProduct(@RequestBody Product product ) {
		Product newProduct = productService.save(product);
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteById(id);
		return ResponseEntity.noContent().build(); // 204- Sin contenido
	}
	
	@GetMapping("/{id}")
    public Product getProductById( @PathVariable("id") Long id )
    {
        return productService.findById(id);
    }
	
	@PutMapping("/{id}")
	Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
		Product updatedProduct = productService.update(id, product);
		return updatedProduct;
	}
	
	@GetMapping("category/{id}")
	public Set<String> getCategoryWithSpecificProductId ( @PathVariable("id") Long id )
    {
        return productService.getCategoryWithSpecificProductoId(id);
    }

}
