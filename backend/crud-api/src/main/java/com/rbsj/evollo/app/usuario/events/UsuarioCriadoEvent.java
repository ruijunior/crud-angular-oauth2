package com.rbsj.evollo.app.usuario.events;

import com.rbsj.evollo.app.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsuarioCriadoEvent {
	
	private Usuario usuario;

}
