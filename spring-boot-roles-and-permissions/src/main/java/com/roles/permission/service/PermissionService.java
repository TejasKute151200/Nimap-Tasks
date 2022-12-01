package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entity.Permission;

public interface PermissionService {
	
	public Permission addPermission(Permission permission);
	
	public List<Permission> getAllPermissions();

	public Permission getPermissionById(long id) throws Exception;

	public Permission editPermission(Permission permisson, long id) throws Exception;

	public void deletePermissionById(long id);

}
