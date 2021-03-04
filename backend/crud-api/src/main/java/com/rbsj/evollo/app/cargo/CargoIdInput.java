package com.rbsj.evollo.app.cargo;

import lombok.Setter;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
@Setter
public class CargoIdInput {
	
	@NotNull
	private Long id;

}
