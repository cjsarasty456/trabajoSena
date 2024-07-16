package com.sena.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.jwt.interfaceService.IUserServices;
import com.sena.jwt.interfaces.IUser;
import com.sena.jwt.model.security.authResponse;
import com.sena.jwt.model.security.loginRequest;
import com.sena.jwt.model.security.registerRequest;
import com.sena.jwt.model.security.role;
import com.sena.jwt.model.security.user;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class authService implements IUserServices  {

    private final IUser data;
    private final jwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public authResponse register(registerRequest request){
        user userData=user.builder()
            .first_name(request.getFirstName())
            .last_name(request.getLastName())
            .role(role.User)
            .user_name(request.getUserName())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        
        data.save(userData);
        return authResponse.builder()
        .token(jwtService.getToken(userData))
        .build();
    }

    public authResponse login(loginRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                 request.getPassword()
                 )
            );
        return new authResponse();
    }
    @Override
    public Optional<user> findByUsername(String userName) {
        return data.findByUsername(userName);
    }

    @Override
    public int delete(String id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<user> findAll() {
        // TODO Auto-generated method stub
        return null;
        //throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
