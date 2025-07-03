package com.medicinasalternativasmx.app.service;

import java.util.Set;

import com.medicinasalternativasmx.app.model.User;

public interface UserService {
	
	/*
     * Recupera todos los roles de forma paginada.
     * @param pageable Configuración de paginación y ordenamiento.
     * @return Una página de roles.
     */
	Iterable<User> findAll();
    /**
     * Busca un rol por su ID.
     * @param id El ID del rol a buscar.
     * @return Contiene el rol.
     */
     User findById(Long id);
    /**
     * Guarda un nuevo rol 
     * @param role El rol a guardar.
     * @return El rol guardado.
     */
    User save(User role);
    
    /**
     * Actualiza un rol existente.
     * @param id El id del rol a actualizar
     * @param role El rol a actualizar.
     * @return El rol actualizado.
     */
    User update(Long id, User role);
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
    Set<String> getRolesWithSpecificUserId(Long id);
}
