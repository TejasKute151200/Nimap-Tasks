package com.springrestapi.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String message;
	private HttpStatus status;
	private Object fields;

	public ErrorResponse(String message, HttpStatus status, Object fields) {
		super();
		this.message = message;
		this.status = status;
		this.fields = fields;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getFields() {
		return fields;
	}

	public void setFields(Object fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "SuccessResponse [message=" + message + ", status=" + status + ", fields=" + fields + "]";
	}

}
