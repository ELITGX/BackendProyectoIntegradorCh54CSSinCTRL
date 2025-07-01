package com.medicinasalternativasmx.app.service;

import java.util.Set;

import com.medicinasalternativasmx.app.model.Order;

public interface OrderService {
	/*
     * Recupera todos los Orders de forma paginada.
     * @param pageable Configuración de paginación y ordenamiento.
     * @return Una página de Orders.
     */
	Iterable<Order> findAll();
    /**
     * Busca un rol por su ID.
     * @param id El ID del rol a buscar.
     * @return Contiene el rol.
     */
     Order findById(Long id);
    /**
     * Guarda un nuevo rol 
     * @param Order El rol a guardar.
     * @return El rol guardado.
     */
    Order save(Order order);
    
    /**
     * Actualiza un rol existente.
     * @param id El id del rol a actualizar
     * @param Order El rol a actualizar.
     * @return El rol actualizado.
     */
    Order update(Long id, Order order);
    /**
     * Elimina un rol por su ID.
     * @param id El ID del rol a eliminar.
     */
    void deleteById(Long id);
  /**
     * Encuentra todos los usuarios que tienen un rol con un ID específico
     * @param id El ID del rol a buscar
     * @return Colección de usuarios encontrados
     */
    Set<String> getProductsWithSpecificOrderId(Long id);

}
