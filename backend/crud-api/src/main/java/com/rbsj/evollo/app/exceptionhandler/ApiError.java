package com.rbsj.evollo.app.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(value = Include.NON_NULL)
@Builder
@Getter
public class ApiError {

	private LocalDateTime dataHora;
	private String mensagem;
	private List<Field> fields;
	
	@Getter
	@Builder
	public static class Field{
		private String nome;
		private String menssagemUsuario;
	}

}
