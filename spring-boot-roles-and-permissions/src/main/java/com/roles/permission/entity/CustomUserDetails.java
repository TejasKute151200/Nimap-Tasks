package com.roles.permission.entity;

import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomUserDetails implements UserDetails {

	/**
	 * Created By TejTechWorld
	 **/

	private static final long serialVersionUID = 4533769757026149171L;
	
	@Autowired
	private User user;
	
	@Autowired
	private Role role;

	public CustomUserDetails() {
		super();
	}

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}
	
	public CustomUserDetails(Role role) {
		super();
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		HashSet<SimpleGrantedAuthority> set = new HashSet<>();

		set.add(new SimpleGrantedAuthority(role.getRole()));
		return set;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}
	
}