package com.medicinasalternativasmx.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicinasalternativasmx.app.model.Role;
import com.medicinasalternativasmx.app.service.RoleService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
	RoleService roleService ;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping // ("/api/v1/roles") http://localhost:8080/api/v1/roles
	Iterable<Role> getAllRoles(){
		Iterable<Role> roles = roleService.findAll();
		return roles;
	}
	
	@PostMapping
	Role createRole(@RequestBody Role role) {
		Role newRole = roleService.save(role);
	return newRole;
	}
	
	@DeleteMapping
	String deleteRole(@PathVariable Long id) {
		String name = roleService.deleteById( id );
		return "se borro el rol con id :" +name; 
	}
}
