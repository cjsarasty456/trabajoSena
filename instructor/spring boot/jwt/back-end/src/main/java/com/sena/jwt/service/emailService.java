package com.sena.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
	private JavaMailSender javaMailSender;

	public String enviarCorreocreacionCuenta(String correo, String contrasena) {
		try {
			String asunto="Notificación de creación usuario";
			String cuerpo=""
				    +"<h1>Bienvenido a nuestra plataforma</h1>"
			        +"<p>Cordial saludo este correo electrónico es para notificar sus credenciales de inicio sesión en nuestra"
			        +"   plataforma"
			        +"</p>"
			        +"<h5>Datos</h5>"
			        +"<ul>"
			        +"  <li>Usuario: "+correo+"</li>"
			        +"  <li>Contraseña: "+contrasena+"</li>"
			        +"</ul>"
			        +"<p>"
			        +"  Puede ingresar a nuestra plataforma usando el siguiente enlace <a href='http://localhost:8080/login'>"
			        +"  http://localhost:8080/login</a>"
			        +"</p>";
			        
			var retorno=enviarCorreo(correo,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
			
		}catch (Exception e) {
			return "Erro al envíar "+e.getMessage();
		}
	}
	
	public String enviarCorreorecuperacionCuenta(String correo, String contrasena) {
		try {
			String asunto="Notificación de recuperación de cuenbta";
			String cuerpo=""
				    +"<h1>Bienvenido a nuestra plataforma</h1>"
			        +"<p>Cordial saludo este correo electrónico es para notificar las nuevas contraseñas para ingresar a nuestra"
			        +"   plataforma"
			        +"</p>"
			        +"<h5>Datos</h5>"
			        +"<ul>"
			        +"  <li>Usuario: "+correo+"</li>"
			        +"  <li>Contraseña: "+contrasena+"</li>"
			        +"</ul>"
			        +"<p>"
			        +"  Puede ingresar a nuestra plataforma usando el siguiente enlace <a href='http://localhost:8080/login'>"
			        +"  http://localhost:8080/login</a>"
			        +"</p>";
			        
			var retorno=enviarCorreo(correo,asunto,cuerpo);
			if(retorno) {
				return "se envió correctamente";
			}else {
				return "No se pudo envíar";
			}
		}catch (Exception e) {
			return "Erro al envíar "+e.getMessage();
		}
	}
	public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
	}
}
