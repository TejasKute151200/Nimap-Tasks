package com.springrestapi.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse {

	private String message;
	private String msgKey;
	private HttpStatus status;
	private Object fields;

	public SuccessResponse(String message, String msgKey, HttpStatus status, Object fields) {
		super();
		this.message = message;
		this.msgKey = msgKey;
		this.status = status;
		this.fields = fields;
	}

	public SuccessResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
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
		return "SuccessResponse [message=" + message + ", msgKey=" + msgKey + ", status=" + status + ", fields="
				+ fields + "]";
	}

}
