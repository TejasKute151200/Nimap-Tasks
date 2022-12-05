package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public List<User> getAllUsers();

	public User getUserById(long id) throws Exception;

	public User editUser(User user, long id) throws Exception;

	public void deleteUserById(long id);

//	public List<User> findByAllUsingDto();

//	public User findByIdUsingDto(long id) throws Exception;

//	public List<User> getAllOrderByDesc();
	
//	public List<User> findAllByPage(Integer pageNumber, Integer pageSize);

}
