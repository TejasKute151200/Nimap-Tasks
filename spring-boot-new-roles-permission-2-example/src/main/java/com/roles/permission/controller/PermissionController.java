package com.roles.permission.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roles.permission.entity.Permission;
import com.roles.permission.service.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService ;

	@PreAuthorize("hasAuthority('READ')")
	@GetMapping("/")
	public List<Permission> getAllPermissions() { 
		return permissionService.getAllPermissions();
	}
	
	@GetMapping("/{id}")
	public Permission getPermissionById(@PathVariable long id) throws Exception {
		return permissionService.getPermissionById(id);
	}

	@PreAuthorize("hasAuthority('ADD') or hasRole('ADMIN')")
	@PostMapping("/")
	public Permission addPermission(@RequestBody Permission permission) {
		return permissionService.addPermission(permission);
	}
	
	@PutMapping("/{id}")
	public Permission editPermission(@PathVariable(value = "id") long id,@RequestBody Permission permission) throws Exception {
		return permissionService.editPermission(permission,id);
	}

	@DeleteMapping("/{id}")
	public void deletePermissionById(@PathVariable long id) {
		permissionService.deletePermissionById(id);	 
	}
	
}
