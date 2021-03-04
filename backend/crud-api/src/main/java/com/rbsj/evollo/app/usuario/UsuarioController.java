package com.rbsj.evollo.app.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbsj.evollo.app.converter.UsuarioModelConverter;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioModelConverter usuarioModelConverter;
	
	@PostMapping
	public UsuarioModel salvar(@RequestBody @Valid UsuarioInput usuarioInput) {
		var usuario = usuarioModelConverter.toDomainObject(usuarioInput);
		return usuarioModelConverter.toModel(this.usuarioService.salvar(usuario));
	} 
}
