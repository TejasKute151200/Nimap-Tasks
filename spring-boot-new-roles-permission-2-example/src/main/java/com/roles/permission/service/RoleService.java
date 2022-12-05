package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entity.Role;

public interface RoleService {
	
	public Role addRole(Role role);
	
	public List<Role> getAllRoles();

	public Role getRoleById(long id) throws Exception;

	public Role editRole(Role role, long id) throws Exception;

	public void deleteRoleById(long id);

}
