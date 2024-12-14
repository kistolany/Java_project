package com.tolany.java.Java_project.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorResponse {

	private HttpStatus ErrorResponse;
	private String message;
}
