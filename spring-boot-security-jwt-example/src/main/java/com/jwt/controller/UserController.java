package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println(jwtRequest);
		
		try {
//			System.out.println("1");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));	
//			System.out.println("2");
		}catch (UsernameNotFoundException e) {
//			System.out.println("3");
			e.printStackTrace();
//			System.out.println("4");
			throw new Exception("Oops !! User Not Found");
		}catch (BadCredentialsException be) {
			be.getMessage();
			throw new Exception("Bad Credentials");
		}
//		System.out.println("5");
		
		 UserDetails userDetails =this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
//		 System.out.println("6");
	  String token	= this.userUtil.generateToken(userDetails);
//	  System.out.println("7");
	  System.out.println("JWT Token : "+ token);
//	  System.out.println("8");
	  return ResponseEntity.ok(new JwtResponse(token));
	}

}