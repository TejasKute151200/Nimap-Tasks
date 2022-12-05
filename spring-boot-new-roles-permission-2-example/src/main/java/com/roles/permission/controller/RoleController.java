package com.roles.permission.controller;

import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roles.permission.entity.Role;
import com.roles.permission.repo.PermissionRepo;
import com.roles.permission.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private PermissionRepo permissionRepo;
	
	@Autowired
	private RoleService roleService ;

	@GetMapping("/")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
	
	@GetMapping("/{id}")
	public Role getRoleById(@PathVariable long id) throws Exception {
		return roleService.getRoleById(id);
	}

	@PostMapping("/")
	public Role addRole(@RequestBody Role role) {
		
		System.out.println(role.getPermissions());
//		role.setPermissions( new HashSet<> (permissionRepo.findAll()) );
		
		return roleService.addRole(role);
	}
	
	@PutMapping("/{id}")
	public Role editRole(@PathVariable(value = "id") long id,@RequestBody Role role) throws Exception {
		return roleService.editRole(role,id);
	}

	@DeleteMapping("/{id}")
	public void deleteRoleById(@PathVariable long id) {
		roleService.deleteRoleById(id);	 
	}
	
}
