package com.medicinasalternativasmx.app.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	ResponseEntity<Iterable<User>> getAllUsers(){
		Iterable<User> users = userService.findAll();
		return ResponseEntity.ok(users);
	}
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.save(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED); // 201
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		
		return ResponseEntity.noContent().build(); // 204 - sin contenido
	}
	
	@GetMapping("/{id}")
    public User getUserById( @PathVariable("id") Long id )
    {
        return userService.findById(id);
    }
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
	    return userService.findByEmail(email)
	            .map(user -> ResponseEntity.ok(user))
	            .orElse(ResponseEntity.notFound().build());
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

