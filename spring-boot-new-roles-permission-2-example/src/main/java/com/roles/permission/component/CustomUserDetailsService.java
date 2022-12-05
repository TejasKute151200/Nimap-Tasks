package com.roles.permission.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.roles.permission.entity.User;
import com.roles.permission.repo.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepo userRepo;
   
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User With username [" + username + "] Not Found");
        }

//        System.out.println(authorities);
        return new CustomUserDetails(user);
    }
}
