package com.example.demo.exceptionHandler;

public class RecordNotFoundException extends RuntimeException{
	public RecordNotFoundException(String message){
		super(message);
	}
}
