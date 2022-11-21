package com.springrestapi.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class StudentNotFoundException extends Exception{

	/**
	 * Created By TejTechWorld
	 */
	
	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException (Long id){
		
		super(String.format("Student Id %s not found",id));
		
	}
	

}
