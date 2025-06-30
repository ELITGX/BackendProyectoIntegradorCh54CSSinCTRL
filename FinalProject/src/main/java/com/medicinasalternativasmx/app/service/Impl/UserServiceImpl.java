package com.medicinasalternativasmx.app.service.Impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.medicinasalternativasmx.app.model.Role;
import com.medicinasalternativasmx.app.model.User;
import com.medicinasalternativasmx.app.repository.UserRepository;
import com.medicinasalternativasmx.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// Método para devolver toda la tabla user
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	// Método para devolver los datos de un user especifico
	@Override
	public User findById(Long id) {
		Optional <User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	// Método de guardado de un nuevo user
	@Override
	public User save(User user) {
		user.setId(null);
		User newUser = userRepository.save(user);
		return newUser;
	}
	
	// Método de actualización de user a partir del id 
	@Override
	public User update(Long id, User userUpdate) {
		Optional <User> userOpt = userRepository.findById(id);
		
		if(userOpt.isPresent()) {
			User user = userOpt.get();
			user.setName(userUpdate.getName());
			user.setlastName(userUpdate.getlastName());
			user.setEmail(userUpdate.getEmail());
			user.setPhone(userUpdate.getPhone());
			user.setPassword(userUpdate.getPassword());
			return userRepository.save(user);
		}
		
		return null;
	}
	// Método de borrado de un user especifico por id
	@Override
	public String deleteById(Long id) {
		Optional <User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
			return "Se borró el rol: " + user.get().getName();
		}
		
		return String.format("No se encontró el rol con el id: %d, no se borró ningún rol", id);
	}

	// Método de obtención de users con un id de usuario especifico
	@Override
	public Set<String> getRolesWithSpecificUserId(Long id) {
		Optional <User> userOpt = userRepository.findById(id);
		if(userOpt.isPresent()) {
			User user = userOpt.get();
			Set<Role> roles = user.getRoles();
			
			Set<String> roleWithSpecificUser = new HashSet<String>(); 
			
			for (Role role : roles) {
				roleWithSpecificUser.add(role.getName());
			}
			
			return roleWithSpecificUser;
		}
		
		return null;
	}
	
	
}
