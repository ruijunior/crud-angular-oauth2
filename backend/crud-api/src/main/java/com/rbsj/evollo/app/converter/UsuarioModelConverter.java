package com.rbsj.evollo.app.converter;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rbsj.evollo.app.usuario.Usuario;
import com.rbsj.evollo.app.usuario.UsuarioInput;
import com.rbsj.evollo.app.usuario.UsuarioModel;

@Component
public class UsuarioModelConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public Usuario toDomainObject(@Valid UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}

	public UsuarioModel toModel(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioModel.class);
	}

}
