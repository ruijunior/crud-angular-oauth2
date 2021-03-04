package com.rbsj.evollo.app.funcionario.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rbsj.evollo.app.funcionario.events.FuncionarioCriadoEvent;
import com.rbsj.evollo.app.usuario.Usuario;
import com.rbsj.evollo.app.usuario.UsuarioService;

@Component
public class CriacaoUsuarioFuncionarioCriadoListener {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@EventListener
	public void aoCriarFuncionario(FuncionarioCriadoEvent event) {
		var funcionario = event.getFuncionario();
		var usuario = new Usuario();
		usuario.setEmail(funcionario.getEmail());
		usuario.setEmpresa(funcionario.getEmpresa());
		usuario.setNome(funcionario.getNome());
		usuario.setSenha(usuarioService.generatePassword());
		usuario.setCadastroUsuarioPeloFuncionario(Boolean.TRUE);
		usuarioService.salvar(usuario);
	}
}