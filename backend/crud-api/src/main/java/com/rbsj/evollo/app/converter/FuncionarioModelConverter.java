package com.rbsj.evollo.app.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rbsj.evollo.app.cargo.Cargo;
import com.rbsj.evollo.app.funcionario.Funcionario;
import com.rbsj.evollo.app.funcionario.FuncionarioInput;
import com.rbsj.evollo.app.funcionario.FuncionarioModel;

@Component
public class FuncionarioModelConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<FuncionarioModel> toCollectionModel(List<Funcionario> funcionarios) {
		return funcionarios.stream()
				.map(func -> toModel(func))
				.collect(Collectors.toList());
	}

	public FuncionarioModel toModel(Funcionario func) {
		return modelMapper.map(func, FuncionarioModel.class);
	}
	
	public Funcionario toDomainObject(FuncionarioInput funcionarioInput) {
		return modelMapper.map(funcionarioInput, Funcionario.class);
	}
	
	public void copyToDomainObject(FuncionarioInput funcionarioInput, Funcionario funcionario) {
		funcionario.setCargo(new Cargo());
		modelMapper.map(funcionarioInput, funcionario);
	}

}
