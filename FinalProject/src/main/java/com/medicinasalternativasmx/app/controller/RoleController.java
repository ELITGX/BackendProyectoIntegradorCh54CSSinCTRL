package com.medicinasalternativasmx.app.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@DeleteMapping("/{id}")
	String deleteRole(@PathVariable("id") Long id) {
		
		return roleService.deleteById( id );
	}
	@GetMapping("/{id}")
    public Role getRoleById( @PathVariable("id") Long id )
    {
        return roleService.findById(id);
    }
	
	@PutMapping("/{id}")
	Role updateRole(@RequestBody Role role, @PathVariable("id") Long id) {
		Role updatedRole = roleService.update(id, role);
		return updatedRole;
	}
	
	@GetMapping("users/{id}")
	public Set<String> getUsersWithSpecificRoleId ( @PathVariable("id") Long id )
    {
        return roleService.getUsersWithSpecificRoleId(id);
    }
	
	
}
