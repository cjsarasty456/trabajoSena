package com.sena.jwt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//este archivo va a contener
//los datos básicos para conectarse 
//a la cuenta de gmail

@Configuration
public class emailConfiguration {
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("practicaadsoneiva@gmail.com");
		mailSender.setPassword("jlcq yslr vwqp hlim");
		
		Properties properties=mailSender.getJavaMailProperties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		return mailSender;
	}
}