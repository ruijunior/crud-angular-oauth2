package com.rbsj.evollo.app.infra.service;

public class EmailException extends RuntimeException{

	private static final long serialVersionUID = -6275109054139201030L;
	
	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmailException(String message) {
		super(message);
	}

}
