package br.com.serratec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setFrom("gabriela.c.duarte7@aluno.senai.br");
		mail.setTo(para);
		mail.setSubject(assunto);
		mail.setText("Dados de cadastro do cliente:\n"+texto+"\n\natividade ecommerce - grupo 3");
		javaMailSender.send(mail);
	}
}
