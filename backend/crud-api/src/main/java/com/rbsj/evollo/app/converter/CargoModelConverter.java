package com.rbsj.evollo.app.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rbsj.evollo.app.cargo.Cargo;
import com.rbsj.evollo.app.cargo.CargoInput;
import com.rbsj.evollo.app.cargo.CargoModel;

@Component
public class CargoModelConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CargoModel> toCollectionModel(List<Cargo> cargos) {
		return cargos.stream()
				.map(cargo -> toModel(cargo))
				.collect(Collectors.toList());
	}

	public CargoModel toModel(Cargo cargo) {
		return modelMapper.map(cargo, CargoModel.class);
	}
	
	public Cargo toDomainObject(CargoInput cargoInput) {
		return modelMapper.map(cargoInput, Cargo.class);
	}
	
	public void copyToDomainObject(CargoInput cargoInput, Cargo cargo) {
		modelMapper.map(cargoInput, cargo);
	}

}
