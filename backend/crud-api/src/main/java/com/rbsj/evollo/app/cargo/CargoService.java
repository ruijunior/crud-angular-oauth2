package com.rbsj.evollo.app.cargo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbsj.evollo.app.empresa.Empresa;
import com.rbsj.evollo.app.empresa.EmpresaService;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	public Cargo salvar(Cargo cargo) {
		Long empresaId = cargo.getEmpresa().getId();
		Empresa empresa = this.empresaService.buscar(empresaId);
		cargo.setEmpresa(empresa);
		return this.cargoRepository.save(cargo);
	}
	
	public List<Cargo> listar(Empresa empresa) {
		return this.cargoRepository.findByEmpresa(empresa);
	}

	public Cargo buscar(Long cargoId) {
		return this.cargoRepository.findById(cargoId).get();
	}
}
