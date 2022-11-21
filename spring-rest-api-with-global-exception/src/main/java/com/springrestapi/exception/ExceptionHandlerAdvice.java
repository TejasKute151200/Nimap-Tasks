package com.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	
@ResponseBody
@ExceptionHandler(StudentNotFoundException.class)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
	String StudentNotFoundExceptionHandler(StudentNotFoundException ex){
	
		return ex.getMessage();
	}

}
