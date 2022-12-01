package com.roles.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.roles.permission.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
