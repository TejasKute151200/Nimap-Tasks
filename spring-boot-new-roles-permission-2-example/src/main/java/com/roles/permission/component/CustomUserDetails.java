package com.roles.permission.component;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.roles.permission.entity.Role;
import com.roles.permission.entity.User;
import com.roles.permission.repo.UserRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    
    private User user;
    
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
//		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
//		set.add(new SimpleGrantedAuthority(this.user.getUsername()));
//		return set;
		
		Set<Role> roles = this.user.getRoles();

		Collection<GrantedAuthority> authorities = new ArrayList<>(roles.size());
		for(Role newRole:roles) {
			authorities.addAll(newRole.getPermissions().stream().map(a-> new SimpleGrantedAuthority(a.getPermissionName())).collect(Collectors.toList()));
		}
		
		return authorities;
	}


    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
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
