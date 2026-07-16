package com.esmael.SecureAuth.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ApiError> handleEmailAlreadyExists(EmailAlreadyExistsException ex, HttpServletRequest request){
	
		 ApiError error = ApiError.builder()
	                .timestamp(LocalDateTime.now())
	                .status(HttpStatus.CONFLICT.value())
	                .error(HttpStatus.CONFLICT.getReasonPhrase())
	                .message(ex.getMessage())
	                .path(request.getRequestURI())
	                .build();

	        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}
