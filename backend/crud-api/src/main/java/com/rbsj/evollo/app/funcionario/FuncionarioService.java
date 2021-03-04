package com.rbsj.evollo.app.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbsj.evollo.app.cargo.Cargo;
import com.rbsj.evollo.app.cargo.CargoService;
import com.rbsj.evollo.app.comum.exceptions.EntidadeNaoEncontradaException;
import com.rbsj.evollo.app.empresa.Empresa;
import com.rbsj.evollo.app.empresa.EmpresaService;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private CargoService cargoService;
	
	public List<Funcionario> listar(Long empresaId) {
		return this.funcionarioRepository.findByEmpresaId(empresaId);
	}
	
	public Funcionario buscar(Long id) {
		return this.funcionarioRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de funcionário com id %d", id)));
	}
	
	public Funcionario salvar(Funcionario funcionario) {
		Long empresaId = funcionario.getEmpresa().getId();
		Long cargoId = funcionario.getCargo().getId();
		
		Empresa empresa = this.empresaService.buscar(empresaId);
		Cargo cargo = this.cargoService.buscar(cargoId);
		
		funcionario.setEmpresa(empresa);
		funcionario.setCargo(cargo);
		
		if(funcionario.getId() == null) {
			funcionario.criar();			
		}
		
		return this.funcionarioRepository.save(funcionario);
	}
}
