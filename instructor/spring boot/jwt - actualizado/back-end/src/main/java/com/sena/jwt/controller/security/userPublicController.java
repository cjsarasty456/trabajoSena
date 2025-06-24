package com.sena.jwt.controller.security;

import org.springframework.web.bind.annotation.RestController;

import com.sena.jwt.DTO.authResponse;
import com.sena.jwt.DTO.loginRequest;
import com.sena.jwt.DTO.registerRequest;
import com.sena.jwt.service.authService;
import com.sena.jwt.service.emailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/public/user")
@CrossOrigin
@RequiredArgsConstructor
public class userPublicController {

    private final authService authService;
    private final emailService emailService;

    @PostMapping("/login/")
    public ResponseEntity<authResponse> login(@RequestBody loginRequest request) {
        authResponse response =authService.login(request);
        return new ResponseEntity<authResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/register/")
    public ResponseEntity<authResponse> register(@RequestBody registerRequest request) throws MessagingException {
        authResponse response = authService.register(request);
        emailService.enviarCorreocreacionCuenta(request.getUsername(), request.getPassword());
        return new ResponseEntity<authResponse>(response, HttpStatus.OK);
    }

}
