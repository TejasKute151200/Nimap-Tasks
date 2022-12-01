package com.roles.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.roles.permission.config.JwtTokenUtil;
import com.roles.permission.entity.User;
import com.roles.permission.config.JwtResponse;

@RestController
public class TokenController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/hello")
	public String hello() {	return "Hey Hello You Are Authenticate With JWT"; }

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody User jwtRequest) throws Exception{
		
		System.out.println(jwtRequest);
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));	
		}catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Oops !! User Not Found");
		}catch (BadCredentialsException be) {
			be.getMessage();
			throw new Exception("Bad Credentials");
		}
		
		 UserDetails userDetails =this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	  String token	= this.jwtTokenUtil.generateToken(userDetails);
	  System.out.println("JWT Token : "+ token);
	  return ResponseEntity.ok(new JwtResponse(token));
	}

}