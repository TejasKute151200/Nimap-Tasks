package com.jwt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse implements Serializable{
	
	/**
	 * Created By TejTechWorld
	 **/
	private static final long serialVersionUID = 2847786779770849727L;
	
	private final String token;

}
