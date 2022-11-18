package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.jwt.service.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService service;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		// return NoOpPasswordEncoder.getInstance();

		return new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
//		.csrf().disable()
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests()
				.antMatchers("/signin").permitAll()
//		.antMatchers("/public/**").permitAll()   // .antMatchers(HttpMethod.GET,"/public/**").permitAll()
				.antMatchers("/public/**").hasRole("USER").antMatchers("/users/**").hasRole("ADMIN").anyRequest()
				.authenticated().and()
//		.httpBasic();
				.formLogin().loginPage("/signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/users/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(service).passwordEncoder(passwordEncoder());

//		auth.inMemoryAuthentication().withUser("tejaskute").password(this.passwordEncoder().encode("Tejas@123")).roles("USER");
//		auth.inMemoryAuthentication().withUser("sanjaykute").password(this.passwordEncoder().encode("Sanjay@123")).roles("ADMIN");

//		ROLES - High Level OverView -> USER, ADMIN, PUBLIC
//		AUTHORITY - Give PERMISSIONs For Specific ROLE 
//		
//		For Eg., ADMIN Can Permit All But User Can READ Because of Authority

	}

}
