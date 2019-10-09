package com.example.demo.exceptionHandler;

public class DuplicateRecordsException extends RuntimeException {
	
	public DuplicateRecordsException(String message) {
		super(message);
	}

}
