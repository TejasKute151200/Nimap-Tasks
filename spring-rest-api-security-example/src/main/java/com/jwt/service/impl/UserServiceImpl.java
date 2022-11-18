package com.jwt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.entity.User;
import com.jwt.repo.UserRepo;
import com.jwt.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public List<User> getAllUsers()	{
	return this.repo.findAll();
}
	@Override
	public User getByUser(String username) {
		
		return this.repo.findByUsername(username);
	}
	
	@Override
	public User addUser(User user) {
		
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		
		return this.repo.save(newUser);
	}

}
