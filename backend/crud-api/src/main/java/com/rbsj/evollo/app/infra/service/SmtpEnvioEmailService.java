package com.rbsj.evollo.app.infra.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rbsj.evollo.core.EmailProperties;

@Service
public class SmtpEnvioEmailService implements EnvioEmailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailProperties emailProperties;
	
	@Override
	public void enviar(Mensagem mensagem) {
		try {
			var mimeMessage = mailSender.createMimeMessage();
			
			var helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setFrom(emailProperties.getRemetente());
			helper.setSubject(mensagem.getAssunto());
			helper.setTo(mensagem.getDestinatario());
			helper.setText(mensagem.getConteudo(), true);
			
			
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new EmailException("Email não enviado!", e);
		}
		
	}

}
