package com.sena.jwt.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.jwt.model.security.rol;
import com.sena.jwt.repository.IRol;

// import com.sena.jwt.DTO.authResponse;
// import com.sena.jwt.DTO.loginRequest;
// import com.sena.jwt.DTO.registerRequest;
// import com.sena.jwt.repository.IUser;

// import com.sena.jwt.model.security.user;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class rolService {


    private final IRol data;

    public rol getRolDefault(){
        return data.getRolDefault();
    }

    // public authResponse register(registerRequest request){
    
    //     user userData=user.builder()
    //         .first_name(request.getFirstname())
    //         .last_name(request.getLastname())
    //         // .role()
    //         .user_name(request.getUsername())
    //         .password(passwordEncoder.encode(request.getPassword()))
    //         .build();
        
    //     data.save(userData);
    //     return authResponse.builder()
    //     .token(jwtService.getToken(userData))
    //     .build();
    // }

    // public authResponse login(loginRequest request){
    //     authenticationManager.authenticate(
    //         new UsernamePasswordAuthenticationToken(
    //             request.getUsername(),
    //              request.getPassword()
    //              )
    //         );
    //     user user=findByUsername(request.getUsername()).orElseThrow();
    //     String token=jwtService.getToken(user);
    //     return authResponse.builder()
    //     .token(token)
    //     .build();
    // }
    
    
    // public Optional<user> findByUsername(String userName) {
    //     return data.findByUsername(userName);
    // }

    
    // public int delete(String id) {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

    
    // public List<user> findAll() {
    //     // TODO Auto-generated method stub
    //     return null;
    //     //throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    // }

}
