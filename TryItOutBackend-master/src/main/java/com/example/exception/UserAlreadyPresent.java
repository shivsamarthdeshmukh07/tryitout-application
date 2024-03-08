package com.example.exception;

public class UserAlreadyPresent extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAlreadyPresent(){
		
	}
	public UserAlreadyPresent(String messg){
		super(messg);
	}
}
