package com.medicinasalternativasmx.app.service.Impl;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.medicinasalternativasmx.app.model.Role;
import com.medicinasalternativasmx.app.repository.RoleRepository;
import com.medicinasalternativasmx.app.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long id) {
		Optional <Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			return role.get();
		}
		return null;
	}

	@Override
	public Role save(Role role) {
		role.setId(null);
		Role newRole = roleRepository.save(role);
		return newRole;
	}

	@Override
	public Role update(Long id, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Long id) {
		Optional <Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			roleRepository.deleteById(id);
			return "Se borró el rol: " + role.get().getName();
		}
		
		return String.format("No se encontró el rol con el id: %d, no se borró ningún rol", id);
	}

	@Override
	public Set<String> getUsersWithSpecificRoleId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
