package com.cico.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showMYCustomError(ResourceNotFoundException rnfe)
	{
		return new ResponseEntity<MyErrorResponse>(
				new MyErrorResponse(new Date().toString(),
						"Resource Not Found",
						rnfe.getMessage()),HttpStatus.NOT_FOUND);
				
	}

	@ExceptionHandler(ResourceAlreadyFoundException.class)
	public ResponseEntity<MyErrorResponse> showMYCustomError(ResourceAlreadyFoundException rfe)
	{
		return new ResponseEntity<MyErrorResponse>(
				new MyErrorResponse(new Date().toString(),
						"Resource Is Already Exist",
						rfe.getMessage()),HttpStatus.FOUND);
				
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<MyErrorResponse> showMYCustomError(InvalidCredentialsException ice)
	{
		return new ResponseEntity<MyErrorResponse>(
				new MyErrorResponse(new Date().toString(),
						"INVALID_CREDENTIALS",
						ice.getMessage()),HttpStatus.UNAUTHORIZED);			
	}
	
}