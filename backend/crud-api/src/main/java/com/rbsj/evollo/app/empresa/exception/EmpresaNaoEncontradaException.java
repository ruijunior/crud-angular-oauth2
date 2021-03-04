package com.rbsj.evollo.app.empresa.exception;

import com.rbsj.evollo.app.comum.exceptions.EntidadeNaoEncontradaException;

public class EmpresaNaoEncontradaException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 7242039258288441471L;

	public EmpresaNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public EmpresaNaoEncontradaException(Long id) {
		this(String.format("Não existe cadastro de empresa com id %d", id));
	}
}
