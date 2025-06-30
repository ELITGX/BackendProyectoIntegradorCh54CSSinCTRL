package com.medicinasalternativasmx.app.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	 ResponseEntity<Iterable<Role>> getAllRoles(){
			Iterable<Role> roles = roleService.findAll();
			// new ResponseEntity<Iterable<Role>>(roles, HttpStatus.OK);
			return ResponseEntity.ok(roles);		
	}

	
	@PostMapping
	ResponseEntity<Role> createRole(@RequestBody Role role ) {
		Role newRole = roleService.save(role);
		return new ResponseEntity<Role>(newRole, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
		roleService.deleteById(id);
		return ResponseEntity.noContent().build(); // 204- Sin contenido
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
