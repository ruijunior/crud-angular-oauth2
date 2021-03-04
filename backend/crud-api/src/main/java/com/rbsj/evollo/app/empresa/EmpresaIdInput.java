package com.rbsj.evollo.app.empresa;

import lombok.Getter;
import javax.validation.constraints.NotNull;

import lombok.Setter;

@Getter
@Setter
public class EmpresaIdInput {

	@NotNull
	private Long id;
}
