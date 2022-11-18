package com.jwt.service;

import java.util.List;
import com.jwt.entity.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getByUser(String username);

	public User addUser(User user);

}
