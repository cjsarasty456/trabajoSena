package com.sena.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {


	  @Autowired
	    private JavaMailSender javaMailSender;

	    public void enviarCorreoHTML(String destinatario, String asunto, String contenidoHTML) throws MessagingException {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        // Configurar el destinatario, el asunto y el contenido en formato HTML
	        helper.setTo(destinatario);
	        helper.setSubject(asunto);
	        helper.setText(contenidoHTML, true);

	        // Enviar el correo electrónico
	        javaMailSender.send(message);
	    }
}
