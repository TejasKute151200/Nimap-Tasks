package com.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jwt.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

	public User findByUsername(String username);

}
