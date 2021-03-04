package com.rbsj.evollo.app.empresa;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaInput {
	
	@NotBlank
	private String nomeFantasia;
	
	@CNPJ
	@NotBlank
	private String cnpj;

}
