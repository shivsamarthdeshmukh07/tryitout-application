package com.example.exception;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {

	public UserException(){
		
	}
	public UserException(String messg){
		super(messg);
	}
}
