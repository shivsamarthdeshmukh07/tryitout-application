package com.example.exception;

public class UserRegistrationException extends RuntimeException {

	public UserRegistrationException(String mesg){
		super(mesg);
	}
	
}
