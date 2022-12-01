package com.roles.permission.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private AuthenticationFilter authenticationFilter;
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private AuthenticationManagerBuilder managerBuilder;

	@Autowired
	private UserDetailsService userDetailsService;
	
//	@Bean
//	public UserDetailsService detailService() {
//		return userDetailsService();
//	}
//	
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		AuthenticationManagerBuilder globalAuthBuilder = this.context.getBean(AuthenticationManagerBuilder.class);
//		return new UserDetailsServiceDelegator(Arrays.asList(this.managerBuilder, globalAuthBuilder));
//		
//	}
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors().disable()
			.authorizeRequests()
			.antMatchers("/token").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		
		http
			.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	*/
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
	http
		.csrf().disable()
		.cors().disable()
		.authorizeRequests()
		.antMatchers("/token").permitAll()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		
	http
		.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	
	http.authenticationProvider(daoAuthenticationProvider());
	
	DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		
		return defaultSecurityFilterChain;
		
	}
	
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());	}
	*/
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {	return new BCryptPasswordEncoder(10);	}
	
	/*
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {	return super.authenticationManagerBean();	}
	 */
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {	return configuration.getAuthenticationManager(); }
	
}