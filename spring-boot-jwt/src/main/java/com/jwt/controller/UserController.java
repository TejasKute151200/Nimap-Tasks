package com.jwt.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.JwtRequest;
import com.jwt.entity.JwtResponse;
import com.jwt.service.impl.CustomUserDetailsService;
import com.jwt.util.UserUtil;

@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@GetMapping("/hello")
	public String hello() {	return "Hey Hello You Are Authenticate With JWT"; }
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("user blocked",e);
		}catch (BadCredentialsException e) {
			throw new Exception("invalid credentials",e);
		}
		
	}
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println(jwtRequest);
		
		try {
			System.out.println("1");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));	
			System.out.println("2");
		}catch (UsernameNotFoundException e) {
			System.out.println("3");
			e.printStackTrace();
			System.out.println("4");
			throw new Exception("Bad Credentials");
		}
		System.out.println("5");
		
		 UserDetails userDetails =this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		 
	  String token	= this.userUtil.generateToken(userDetails);
	  
	  System.out.println("JWT"+ token);
	  
	  return new ResponseEntity<>(new JwtRequest(), HttpStatus.CREATED);
	}

}