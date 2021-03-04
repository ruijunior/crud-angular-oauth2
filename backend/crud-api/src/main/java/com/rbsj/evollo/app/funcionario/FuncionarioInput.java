package com.rbsj.evollo.app.funcionario;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.br.CPF;

import com.rbsj.evollo.app.cargo.CargoIdInput;
import com.rbsj.evollo.app.empresa.EmpresaIdInput;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class FuncionarioInput {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@PositiveOrZero
	private BigDecimal salario;
	
	@Valid
	@NotNull
	private CargoIdInput cargo;
	
	@Valid
	@NotNull
	private EmpresaIdInput empresa;

}
