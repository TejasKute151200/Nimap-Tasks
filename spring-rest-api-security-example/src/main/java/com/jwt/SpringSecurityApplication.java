package com.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jwt.entity.User;
import com.jwt.repo.UserRepo;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setEmail("hrishi@gmail.com");
		user.setUsername("Hrishikesh");
		user.setPassword(this.encoder.encode("Hrishi@123"));
		user.setRole("ROLE_USER");

		this.repo.save(user);

		User user1 = new User();
		user1.setEmail("tejas@gmail.com");
		user1.setUsername("Tejas");
		user1.setPassword(this.encoder.encode("Tejas@123"));
		user1.setRole("ROLE_ADMIN");

		this.repo.save(user1);
	}

}
