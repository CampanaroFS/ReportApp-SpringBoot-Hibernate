package com.felipedeveloper.reportapp.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipedeveloper.reportapp.services.exception.DataBaseException;
import com.felipedeveloper.reportapp.services.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleEntityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ApiError apiErr = new ApiError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(apiErr);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<ApiError> handleEntityNotFound(DataBaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ApiError apiErr = new ApiError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(apiErr);
	}
	
	

}
