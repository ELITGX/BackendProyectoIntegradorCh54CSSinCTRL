package com.medicinasalternativasmx.app.service.Impl;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.medicinasalternativasmx.app.model.Category;
import com.medicinasalternativasmx.app.model.Product;
import com.medicinasalternativasmx.app.repository.ProductRepository;
import com.medicinasalternativasmx.app.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// Método para devolver toda la tabla product
	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	// Método para devolver los datos de un producto especifico
	@Override
	public Product findById(Long id) {
	/*
	 * La clase Optional es un contenedor introducido en Java 8 que puede contener
	 * un valor no nulo o estar vacío. Se utiliza para evitar errores relacionados
	 * con valores nulos, como NullPointerException, y para expresar claramente
	 * que un valor puede estar presente o no.
	 */
		Optional<Product> productOpt = productRepository.findById(id);
		if( productOpt.isEmpty() ) { // no hay objeto, la variable contiene null
			throw new IllegalStateException("Product does not exist with id " + id);
		}
		Product existingProduct = productOpt.get();
		return existingProduct;
	}

	// Método de guardado de un nuevo product
	@Override
	public Product save(Product product) {
		product.setId(null);
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	
	// Método de actualización de product a partir del id 
	@Override
	public Product update(Long id, Product product) {
		Product existingProduct = findById(id);
		// Solo se modifica los atributos permitidos
		existingProduct.setName( product.getName() );
		existingProduct.setDescription( product.getDescription() );
		// existingProduct.setId( product.getId() ); NO se permite modificar
		Product updatedProduct = productRepository.save( existingProduct );
		return updatedProduct;
	}
	
	// Método de borrado de un producto especifico por id
	@Override
	public void deleteById(Long id) {
		Product existingProduct = findById(id);
		
		
		productRepository.delete(existingProduct);		
	}

	// Método de obtención de productos con un id de productos especifico
	// No implementado aún con Serch
	@Override
	public Set<String> getCategoryWithSpecificProductoId(Long id) {
		Optional <Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			Product produc = productOpt.get();
			Set<Category> categories = produc.getCategory();
			
			Set<String> categoryWithSpecificProduct = new HashSet<String>(); 
			
			for (Category category : categories) {
				categoryWithSpecificProduct.add(category.getName());
			}
			
			return categoryWithSpecificProduct;
		}
		
		
		return null;
	}

}
