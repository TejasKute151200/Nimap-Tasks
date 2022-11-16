package com.jwt.service;

import java.util.List;
import java.util.Optional;

import com.jwt.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public Optional<User> getById(Integer id);
	public Optional<User> getByUser(String username);
	public User addUser(User user);
	
}
