package com.jwt.service.impl;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		if(username.equals("Tejas")) {
			
			return new User("Tejas", "Tejas", new ArrayList<>());
		}
		else {
			
			throw new UsernameNotFoundException("Username Not Found");
		}
		
	}

}
