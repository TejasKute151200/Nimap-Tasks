package com.roles.permission.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roles.permission.entity.Permission;
import com.roles.permission.repo.PermissionRepo;
import com.roles.permission.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	

	@Autowired
	private PermissionRepo permissionRepo;

	@Override
	public List<Permission> getAllPermissions() {
		return permissionRepo.findAll();
	}

	@Override
	public Permission getPermissionById(long id) throws Exception {

		return permissionRepo.findById(id).orElseThrow(()-> new Exception("Permission not Found"));
	}

	@Override
	public Permission addPermission(Permission permission) {
		
		Permission newPermission = new Permission();
		newPermission.setId(permission.getId());
		newPermission.setPermission(permission.getPermission());
		newPermission.setDescription(permission.getDescription());
		
		return permissionRepo.save(newPermission);
	} 

	@Override
	public Permission editPermission(Permission permission, long id) throws Exception {

		Permission newPermission = permissionRepo.findById(id).orElseThrow(() -> new Exception("Permission Not Found"));
		newPermission.setId(permission.getId());
		newPermission.setPermission(permission.getPermission());
		newPermission.setDescription(permission.getDescription());

		return permissionRepo.save(newPermission);
	}

	@Override
	public void deletePermissionById(long id) {
		permissionRepo.deleteById(id);
	}

}
