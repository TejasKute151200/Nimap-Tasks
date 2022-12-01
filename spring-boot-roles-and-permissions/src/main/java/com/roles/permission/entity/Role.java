package com.roles.permission.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String role;
	
	private String description;
	
	@OneToMany(
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
	
	  @ManyToMany(mappedBy = "roles")
	  private Set<User> users = new HashSet<>();
	
}
