package com.rbsj.evollo.app.funcionario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService funcionarioService;
	

	@GetMapping("/{id}")
	public Funcionario buscar(@PathVariable Long id){
		return this.funcionarioService.buscar(id);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid Funcionario funcionario) {
		funcionario = this.funcionarioService.salvar(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return this.funcionarioService.atualizar(id, funcionario);
	}

}
