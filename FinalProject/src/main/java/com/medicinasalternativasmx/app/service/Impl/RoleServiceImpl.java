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
	RoleRepository roleRepository;
	
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
		Optional <Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			return role.get();
		}
		return null;
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
	public Role update(Long id, Role roleUpdate) {
		Optional <Role> roleOpt = roleRepository.findById(id);
		
		if(roleOpt.isPresent()) {
			Role role = roleOpt.get();
			role.setName(roleUpdate.getName());
			role.setDescription(roleUpdate.getDescription());
			return roleRepository.save(role);
		}
		
		return null;
	}
	// Método de borrado de un role especifico por id
	@Override
	public String deleteById(Long id) {
		Optional <Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			roleRepository.deleteById(id);
			return "Se borró el rol: " + role.get().getName();
		}
		
		return String.format("No se encontró el rol con el id: %d, no se borró ningún rol", id);
	}

	// Método de obtención de usuarios con un id de rol especifico
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
