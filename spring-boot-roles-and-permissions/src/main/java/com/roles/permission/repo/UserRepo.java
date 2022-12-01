package com.roles.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.roles.permission.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
