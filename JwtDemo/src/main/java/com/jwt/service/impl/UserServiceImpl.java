package com.jwt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.entity.User;
import com.jwt.repo.UserRepo;
import com.jwt.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	public List<User> getAllUsers()	{
	return this.repo.findAll();
}
	
	public Optional<User> getById(Integer id){
		return this.repo.findById(id);
		
	}

	public Optional<User> getByUser(String username) {
		
		return this.repo.findByUsername(username);
	}
	
	public User addUser(User user) {
		
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		
		return this.repo.save(newUser);
	}

}
