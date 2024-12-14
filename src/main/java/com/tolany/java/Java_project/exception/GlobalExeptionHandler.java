package com.tolany.java.Java_project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handlerApiException(ApiException e){
		ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus()).body(errorResponse);
	}
	
}
