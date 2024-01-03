package com.sena.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;



import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class emailController {
	
	 @Autowired
	    private JavaMailSender javaMailSender;

	    @GetMapping("/enviar-correo")
	    public String enviarCorreo() {
	        try {
	        	String destinatario="cjsarasty@gmail.com";
	        	String asunto="correo prueba 1";
	        	String cuerpo="hola";
	            enviarCorreoHTML(destinatario, asunto, cuerpo);
	            return "Correo enviado exitosamente.";
	        } catch (Exception e) {
	            return "Error al enviar el correo: " + e.getMessage();
	        }
	    }
	    
	    @GetMapping("/enviarcorreoregistro")
	    public String enviarCorreoRegistro() {
	        try {
	        	String destinatario="cjsarasty@gmail.com";
	        	String asunto="Bienvenido al sistema CalicheSoft";
	        	String cuerpo="<div>"
	        			+ "Este correo es para indicar que se ha registrado a Calichesoft, sus credenciales de acceso son"
	        			+ "User:cjsarasty"
	        			+ "Password:1234"
	        			+ "</div>";
	            enviarCorreoHTML(destinatario, asunto, cuerpo);
	            return "Correo enviado exitosamente.";
	        } catch (Exception e) {
	            return "Error al enviar el correo: " + e.getMessage();
	        }
	    }

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
