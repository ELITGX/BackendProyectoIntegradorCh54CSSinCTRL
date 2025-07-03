package com.medicinasalternativasmx.app.service;

import java.util.Set;

import com.medicinasalternativasmx.app.dto.ProductDTO;
import com.medicinasalternativasmx.app.model.Product;

public interface ProductService {

	/*
     * Recupera todos los productos de forma paginada.
     * @param pageable Configuración de paginación y ordenamiento.
     * @return Una página de productos.
     */
	Iterable<Product> findAll();
    /**
     * Busca un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return Contiene el producto.
     */
	Product findById(Long id);
    /**
     * Guarda un nuevo producto 
     * @param product El producto a guardar.
     * @return El producto guardado.
     */
     Product save(ProductDTO productDTO);
    
    /**
     * Actualiza un producto existente.
     * @param id El id del producto a actualizar
     * @param role El producto a actualizar.
     * @return El producto actualizado.
     */
    Product update(Long id, ProductDTO productDTO);
    /**
     * Elimina un producto por su ID.
     * @param id El ID del producto a eliminar.
     */
    void deleteById(Long id);
  /**
     * Encuentra todos los productos que tienen un producto con un ID específico
     * @param id El ID del producto a buscar
     * @return Colección de producto encontrados
     */
    String getCategoryWithSpecificProductoId(Long id);
}
