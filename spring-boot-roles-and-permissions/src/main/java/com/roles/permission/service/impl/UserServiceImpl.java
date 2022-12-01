package com.roles.permission.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roles.permission.entity.User;
import com.roles.permission.repo.UserRepo;
import com.roles.permission.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}


	@Override
	public User getUserById(long id) throws Exception {

		return userRepo.findById(id).orElseThrow(()-> new Exception("User not Found"));
	}

	@Override
	public User addUser(User user) {
		
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRoles(user.getRoles());
		
		return userRepo.save(newUser);
	} 

	@Override
	public User editUser(User user, long id) throws Exception {

		User newUser = userRepo.findById(id).orElseThrow(() -> new Exception("User Not Found"));
		newUser.setId(user.getId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRoles(user.getRoles());

		return userRepo.save(newUser);
	}

	@Override
	public void deleteUserById(long id) {
		userRepo.deleteById(id);
	}

}
