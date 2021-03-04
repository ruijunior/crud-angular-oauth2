package com.rbsj.evollo.app.cargo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbsj.evollo.app.converter.CargoModelConverter;

@RestController
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private CargoModelConverter cargoModelConverter;
	
	@PostMapping
	public CargoModel salvar(@RequestBody @Valid CargoInput cargoInput) {
		Cargo cargo = cargoModelConverter.toDomainObject(cargoInput);
		return cargoModelConverter.toModel(this.cargoService.salvar(cargo));
	}

}
