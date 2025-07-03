package com.medicinasalternativasmx.app.service;

import com.medicinasalternativasmx.app.dto.AddressDTO;
import com.medicinasalternativasmx.app.model.Address;
import java.util.List;

public interface AddressService {
    /**
     * Recupera todas las direcciones.
     * @return todas las direcciones almacenadas.
     */
    Iterable<Address> findAll();
    /**
     * Busca una dirección por su ID.
     * @param id ID de la dirección a buscar.
     * @return la dirección encontrada.
     */
    Address findById(Long id);
    /**
     * Guarda una nueva dirección.
     * @param address la dirección a guardar.
     * @return la dirección guardada.
     */
    Address save(AddressDTO addressDto);
    /**
     * Actualiza una dirección existente.
     * @param id ID de la dirección a actualizar.
     * @param address datos de la dirección actualizada.
     * @return la dirección actualizada.
     */
    Address update(Long id, AddressDTO addressDto);
    /**
     * Elimina una dirección por su ID.
     * @param id ID de la dirección a eliminar.
     */
    void deleteById(Long id);
    /**
     * Obtiene todas las direcciones de un usuario específico.
     * @param userId ID del usuario.
     * @return lista de direcciones del usuario.
     */
    List<Address> findByUserId(Long userId);
}
