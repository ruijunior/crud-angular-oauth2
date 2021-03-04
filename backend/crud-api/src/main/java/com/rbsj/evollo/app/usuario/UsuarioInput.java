package com.rbsj.evollo.app.usuario;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.rbsj.evollo.app.empresa.EmpresaInput;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	@Valid
	@NotNull
	private EmpresaInput empresa;

}
