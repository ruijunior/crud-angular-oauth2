package com.rbsj.evollo.app.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cargos")
public class CargoResource {
	
	@Autowired
	private CargoService cargoService;
	
	@PostMapping
	public Cargo salvar(@RequestBody Cargo cargo) {
		return this.cargoService.salvar(cargo);
	}

}
