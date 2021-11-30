package com.employees.crudspringboot.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling 
{
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handle(EmployeeNotFoundException e)
	{
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleAll(RuntimeException e)
	{
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
