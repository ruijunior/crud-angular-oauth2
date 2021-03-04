package com.rbsj.evollo.app.cargo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.rbsj.evollo.app.empresa.EmpresaIdInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoInput {
	
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	private EmpresaIdInput empresa;

}
