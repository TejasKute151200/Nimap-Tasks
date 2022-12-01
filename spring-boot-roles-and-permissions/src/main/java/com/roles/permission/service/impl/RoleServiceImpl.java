package com.roles.permission.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roles.permission.entity.Role;
import com.roles.permission.repo.RoleRepo;
import com.roles.permission.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}


	@Override
	public Role getRoleById(long id) throws Exception {

		return roleRepo.findById(id).orElseThrow(()-> new Exception("Role not Found"));
	}

	@Override
	public Role addRole(Role role) {
		
		Role newRole = new Role();
		newRole.setId(role.getId());
		newRole.setRole(role.getRole());
		newRole.setDescription(role.getDescription());
		
		return roleRepo.save(newRole);
	} 

	@Override
	public Role editRole(Role role, long id) throws Exception {

		Role newRole = roleRepo.findById(id).orElseThrow(() -> new Exception("Role Not Found"));
		newRole.setId(role.getId());
		newRole.setRole(role.getRole());
		newRole.setDescription(role.getDescription());

		return roleRepo.save(newRole);
	}

	@Override
	public void deleteRoleById(long id) {
		roleRepo.deleteById(id);
	}

}
