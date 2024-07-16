package com.sena.jwt_security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.sena.jwt_security.interfaces.IUsuario;
import com.sena.jwt_security.models.seguridad.authResponse;
import com.sena.jwt_security.models.seguridad.loginRequest;
import com.sena.jwt_security.models.seguridad.registerRequest;
import com.sena.jwt_security.models.seguridad.rol;
import com.sena.jwt_security.models.seguridad.usuario;
import com.sena.jwt_security.services.jwt.jwtServices;
import org.springframework.security.core.Authentication;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class authService {

    @Autowired
    private IUsuario dataUsuario;

    private final jwtServices dataJwt;
      
    private final AuthenticationManager authenticationManager;
    
    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(); 


    public authResponse login(loginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));
        UserDetails user=dataUsuario.findByUsername(request.getUserName()).orElseThrow();
        String token=dataJwt.getToken(user);
        return authResponse.builder()
            .token(token)
            .build();
    }

    public authResponse register(registerRequest request) {
        usuario user=usuario.builder()
        .username(request.getUserName())
        .email(request.getEmail())
        // .password(request.getPassword())
        .password(passwordEncoder.encode(request.getPassword ()))
        .rol(rol.Usuario)
        .build();
        dataUsuario.save(user);
        //falta generar token
        return authResponse.builder()
            .token(dataJwt.getToken(user))
            .build();


    }
    
    
}
