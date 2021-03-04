package com.rbsj.evollo.app.funcionario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbsj.evollo.app.converter.FuncionarioModelConverter;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioModelConverter funcionarioModelConverter;

	
	@GetMapping("/{empresaId}/empresa")
	public List<FuncionarioModel> listar(@PathVariable Long empresaId){
		var lista = this.funcionarioService.listar(empresaId);
		return funcionarioModelConverter.toCollectionModel(lista);
	}

	@GetMapping("/{id}")
	public FuncionarioModel buscar(@PathVariable Long id){
		var funcionario = this.funcionarioService.buscar(id);
		return funcionarioModelConverter.toModel(funcionario);
	}
	
	@PostMapping
	public FuncionarioModel salvar(@RequestBody @Valid FuncionarioInput funcionarioInput) {
		Funcionario funcionario = funcionarioModelConverter.toDomainObject(funcionarioInput);
		return funcionarioModelConverter.toModel(this.funcionarioService.salvar(funcionario));
		
	}
	
	@PutMapping("/{id}")
	public FuncionarioModel atualizar(@PathVariable Long id, @RequestBody @Valid FuncionarioInput funcionarioInput) {
		Funcionario funcionarioAtual = this.funcionarioService.buscar(id);
		funcionarioModelConverter.copyToDomainObject(funcionarioInput, funcionarioAtual);
		return funcionarioModelConverter.toModel(this.funcionarioService.salvar(funcionarioAtual));
	}

}
