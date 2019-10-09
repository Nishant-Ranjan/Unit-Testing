package com.example.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler({DuplicateRecordsException.class})
	public ResponseEntity<Error> handleDuplicateRowException(RuntimeException e){
		return new ResponseEntity<Error>(new Error(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler({RecordNotFoundException.class})
	public ResponseEntity<Error> handleRecordNotFoundException(RuntimeException e){
		return new ResponseEntity<Error>(new Error(e.getMessage(), 404), HttpStatus.NOT_FOUND);
		
	}
}
