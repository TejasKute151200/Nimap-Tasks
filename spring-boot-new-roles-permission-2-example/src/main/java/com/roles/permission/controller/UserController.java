package com.roles.permission.controller;

import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roles.permission.entity.User;
import com.roles.permission.repo.RoleRepo;
import com.roles.permission.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) throws Exception {
		return userService.getUserById(id);
	}
    
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		
		String password = user.getPassword();
		String encrypt = passwordEncoder.encode(password);
		user.setPassword(encrypt);
		user.setRoles( new HashSet<> (roleRepo.findAll()) );
		
		return userService.addUser(user);
	}
	
	@PutMapping("/{id}")
	public User editUser(@PathVariable(value = "id") long id,@RequestBody User user) throws Exception {
		
		String password = user.getPassword();
		String encrypt = passwordEncoder.encode(password);
		user.setPassword(encrypt);
		user.setRoles( new HashSet<> (roleRepo.findAll()));
		
		return userService.editUser(user,id);
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable long id) {
		userService.deleteUserById(id);	 
	}
	
}
