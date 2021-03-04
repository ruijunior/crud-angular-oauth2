package com.rbsj.evollo.app.infra.service;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

public interface EnvioEmailService {
	
	void enviar(Mensagem mensagem);
	
	@Getter
	@Builder
	class Mensagem {
		
		@NonNull
		private String destinatario;
		private String assunto;
		@NonNull
		private String conteudo;
	}

}
