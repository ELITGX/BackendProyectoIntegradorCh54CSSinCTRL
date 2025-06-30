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

import com.medicinasalternativasmx.app.model.User;
import com.medicinasalternativasmx.app.service.UserService;

	
@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	UserService userService ;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping // ("/api/v1/users") http://localhost:8080/api/v1/users
	Iterable<User> getAllUsers(){
		Iterable<User> users = userService.findAll();
		return users;
	}
	
	@PostMapping
	User createUser(@RequestBody User user) {
		User newUser = userService.save(user);
	return newUser;
	}
	
	@DeleteMapping("/{id}")
	String deleteUser(@PathVariable("id") Long id) {
		
		return userService.deleteById( id );
	}
	@GetMapping("/{id}")
    public User getUserById( @PathVariable("id") Long id )
    {
        return userService.findById(id);
    }
	
	@PutMapping("/{id}")
	User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
		User updatedUser = userService.update(id, user);
		return updatedUser;
	}
	
	@GetMapping("roles/{id}")
	public Set<String> getRolesWithSpecificUserId ( @PathVariable("id") Long id )
    {
        return userService.getRolesWithSpecificUserId(id);
    }

}

