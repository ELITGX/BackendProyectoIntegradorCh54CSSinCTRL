package com.medicinasalternativasmx.app.service.Impl;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.medicinasalternativasmx.app.model.Role;
import com.medicinasalternativasmx.app.model.User;
import com.medicinasalternativasmx.app.repository.RoleRepository;
import com.medicinasalternativasmx.app.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	private final RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	// Método para devolver toda la tabla role
	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	// Método para devolver los datos de un role especifico
	@Override
	public Role findById(Long id) {
	/*
	 * La clase Optional es un contenedor introducido en Java 8 que puede contener
	 * un valor no nulo o estar vacío. Se utiliza para evitar errores relacionados
	 * con valores nulos, como NullPointerException, y para expresar claramente
	 * que un valor puede estar presente o no.
	 */
		Optional<Role> roleOpt = roleRepository.findById(id);
		if( roleOpt.isEmpty() ) { // no hay objeto, la variable contiene null
			throw new IllegalStateException("Role does not exist with id " + id);
		}
		Role existingRole = roleOpt.get();
		return existingRole;
	}
	

	// Método de guardado de un nuevo role
	@Override
	public Role save(Role role) {
		role.setId(null);
		Role newRole = roleRepository.save(role);
		return newRole;
	}
	
	// Método de actualización de rolen a partir del id 
	@Override
	public Role update(Long id, Role role) {
		Role existingRole = findById(id);
		// Solo se modifica los atributos permitidos
		existingRole.setName( role.getName() );
		existingRole.setDescription( role.getDescription() );
		// existingRole.setId( role.getId() ); NO se permite modificar
		Role updatedRole = roleRepository.save( existingRole );
		return updatedRole;
	}
	
	// Método de borrado de un role especifico por id
	@Override
	public void deleteById(Long id) {
		Role existingRole = findById(id);
		// existingRole.active(false); // Borrado lógico
		// roleRepository.save( existingRole );
		roleRepository.delete(existingRole);		
	}

	// Método de obtención de usuarios con un id de rol especifico
	// No implementado aún con Serch
	@Override
	public Set<String> getUsersWithSpecificRoleId(Long id) {
		Optional <Role> roleOpt = roleRepository.findById(id);
		if(roleOpt.isPresent()) {
			Role role = roleOpt.get();
			Set<User> users = role.getUsers();
			
			Set<String> userWithSpecificRole = new HashSet<String>(); 
			
			for (User user : users) {
				userWithSpecificRole.add(user.getName());
			}
			
			return userWithSpecificRole;
		}
		
		
		return null;
	}

}
