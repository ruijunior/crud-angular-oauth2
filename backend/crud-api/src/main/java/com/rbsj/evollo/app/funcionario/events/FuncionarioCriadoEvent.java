package com.rbsj.evollo.app.funcionario.events;

import com.rbsj.evollo.app.funcionario.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FuncionarioCriadoEvent {
	
	private Funcionario funcionario;

}
