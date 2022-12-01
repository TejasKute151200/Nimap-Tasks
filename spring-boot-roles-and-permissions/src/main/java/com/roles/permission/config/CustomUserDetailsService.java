package com.roles.permission.config;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("Tejas")) {
			return new User("Tejas", "$2a$10$yIsI8XsTlsk6oIPu8ASFReFAaEgl8lgizFmcxcxhm9TbpnNjdfdzC", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("Username Not Found");
		}
	}
	
}
