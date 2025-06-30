package com.medicinasalternativasmx.app.service;

import java.util.Set;

import com.medicinasalternativasmx.app.model.Role;

public interface RoleService  {
	/*
     * Recupera todos los roles de forma paginada.
     * @param pageable Configuración de paginación y ordenamiento.
     * @return Una página de roles.
     */
	Iterable<Role> findAll();
    /**
     * Busca un rol por su ID.
     * @param id El ID del rol a buscar.
     * @return Contiene el rol.
     */
     Role findById(Long id);
    /**
     * Guarda un nuevo rol 
     * @param role El rol a guardar.
     * @return El rol guardado.
     */
    Role save(Role role);
    
    /**
     * Actualiza un rol existente.
     * @param id El id del rol a actualizar
     * @param role El rol a actualizar.
     * @return El rol actualizado.
     */
    Role update(Long id, Role role);
    /**
     * Elimina un rol por su ID.
     * @param id El ID del rol a eliminar.
     */
    String deleteById(Long id);
  /**
     * Encuentra todos los usuarios que tienen un rol con un ID específico
     * @param id El ID del rol a buscar
     * @return Colección de usuarios encontrados
     */
    Set<String> getUsersWithSpecificRoleId(Long id);
}
