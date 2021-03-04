package com.rbsj.evollo.app.funcionario;

import java.math.BigDecimal;

import com.rbsj.evollo.app.cargo.CargoModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioModel {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private BigDecimal salario;
	private CargoModel cargo;
}
