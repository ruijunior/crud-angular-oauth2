package com.rbsj.evollo.app.comum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException{
	
	
	private static final long serialVersionUID = -3238395033051328812L;

	public NegocioException(String msg) {
		super(msg);
	}
	
	public NegocioException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
