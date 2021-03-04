package com.rbsj.evollo.app.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbsj.evollo.app.empresa.exception.EmpresaNaoEncontradaException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa buscar(Long id) {
		return this.empresaRepository.findById(id)
				.orElseThrow(() -> new EmpresaNaoEncontradaException(id));
	}
}
