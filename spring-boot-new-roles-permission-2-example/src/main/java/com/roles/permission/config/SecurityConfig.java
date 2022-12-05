package com.roles.permission.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.roles.permission.component.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public UserDetailsService detailsService() {
		return new CustomUserDetailsService();
	}
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return  http.authorizeRequests()
////                .antMatchers("/user").access("hasAuthority('canReadUser')")
////                .antMatchers("/admin").access("hasAuthority('canReadAdmin')")
//		 		.antMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                .and().httpBasic();
////                .and().formLogin();
//		
//		 
//    }
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(detailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	 @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/**").permitAll() //.access("hasAuthority('READ')") //.hasAuthority("READ").
		.anyRequest()
		.authenticated()
		.and().httpBasic()
		.and().formLogin()
		.and().logout();
	}
}
