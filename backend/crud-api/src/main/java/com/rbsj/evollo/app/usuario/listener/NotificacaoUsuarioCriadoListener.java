package com.rbsj.evollo.app.usuario.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rbsj.evollo.app.infra.service.EnvioEmailService;
import com.rbsj.evollo.app.infra.service.EnvioEmailService.Mensagem;
import com.rbsj.evollo.app.usuario.Usuario;
import com.rbsj.evollo.app.usuario.events.UsuarioCriadoEvent;

@Component
public class NotificacaoUsuarioCriadoListener {

	@Autowired
	private EnvioEmailService envioEmail;

	@EventListener
	public void aoCriarUsuario(UsuarioCriadoEvent event) {
		Usuario usuario = event.getUsuario();
		
		StringBuilder corpo = new StringBuilder();
		corpo.append("<h1>Dados do acesso</h1><hr/>");
		corpo.append(String.format("<p>Login de acesso: %s</p>", usuario.getEmail()));
		corpo.append(String.format("<p>Senha: %s</p>", usuario.getSenha()));
		
		var mensagem = Mensagem.builder()
				.assunto(usuario.getNome() + " - Credenciais de acesso")
				.conteudo(corpo.toString())
				.destinatario(usuario.getEmail())
			.build();

		envioEmail.enviar(mensagem);
	}
}