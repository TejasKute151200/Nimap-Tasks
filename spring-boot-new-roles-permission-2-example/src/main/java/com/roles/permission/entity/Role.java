package com.roles.permission.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "roles")
public class Role {
	
	@Id
	private long id;
	
	@Column(unique = true)
	private String roleName;
	
//	private String description;
	
	@ManyToMany(
			  fetch = FetchType.LAZY,
		      cascade = CascadeType.ALL
		      )
		  @JoinTable(
				name = "role_permission",
		        joinColumns = { 
		        		@JoinColumn(name = "role_id") 
		        		},
		        inverseJoinColumns = { 
		        		@JoinColumn(name = "permission_id") 
		        		}
				)
	private Set<Permission> permissions = new HashSet<>();
	
	@JsonIgnore
	  @ManyToMany(mappedBy = "roles")
	  private Set<User> users = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(long id, String roleName, Set<Permission> permissions, Set<User> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.permissions = permissions;
		this.users = users;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", permissions=" + permissions + ", users=" + users + "]";
	}
	
}
