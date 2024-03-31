package com.sena.jwt_security.controllers.seguridad;

import org.springframework.web.bind.annotation.RestController;

import com.sena.jwt_security.models.seguridad.authResponse;
import com.sena.jwt_security.models.seguridad.loginRequest;
import com.sena.jwt_security.models.seguridad.registerRequest;
import com.sena.jwt_security.services.authService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/public/")
@RequiredArgsConstructor
public class seguridadPublicController {

    
    private final authService authService;

    @PostMapping("login/")
    public ResponseEntity<authResponse> login(@RequestBody loginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("register/")
    public ResponseEntity<authResponse> register(@RequestBody registerRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}