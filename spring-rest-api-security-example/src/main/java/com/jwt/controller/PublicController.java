package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

	@GetMapping("/home")
	public String home() {
		return "This is Home Page";

	}

	@GetMapping("/login")
	public String login() {
		return "This is our login Page";

	}

	@GetMapping("/register")
	public String register() {
		return "Register For Your Login Credentials";
	}

}
