package com.masai.exception;

public class UserExcepiton extends RuntimeException{
	public UserExcepiton() {}
	
	public UserExcepiton(String message) {
		super(message);
	}
}
