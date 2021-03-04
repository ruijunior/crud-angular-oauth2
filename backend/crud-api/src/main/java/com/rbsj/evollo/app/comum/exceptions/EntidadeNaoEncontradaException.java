package com.rbsj.evollo.app.comum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends NegocioException{
	
	
	private static final long serialVersionUID = -3238395033051328812L;

	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}

}
