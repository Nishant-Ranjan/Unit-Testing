package com.example.demo.exceptionHandler;

import lombok.Getter;


public class Error {
	
	private String message;
	private Integer statusCode;
	public Error(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	

}
