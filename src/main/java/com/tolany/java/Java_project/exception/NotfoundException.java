package com.tolany.java.Java_project.exception;

import org.springframework.http.HttpStatus;

public class NotfoundException extends ApiException{

	public NotfoundException(String resourseName, Integer id) {
		super(HttpStatus.NOT_FOUND,String.format("%s with id=%d is not found",resourseName,id));
	}

}
