package com.roles.permission.config;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable{
	
	/**
	 * Created By TejTechWorld
	 **/
	private static final long serialVersionUID = 2847786779770849727L;
	
	private final String token;

}