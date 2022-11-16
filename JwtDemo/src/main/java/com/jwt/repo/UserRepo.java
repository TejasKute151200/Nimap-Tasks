package com.jwt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

	

}
