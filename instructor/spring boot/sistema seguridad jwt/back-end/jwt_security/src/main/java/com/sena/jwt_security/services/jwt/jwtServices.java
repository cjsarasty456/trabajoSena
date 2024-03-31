package com.sena.jwt_security.services.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
@RequiredArgsConstructor
public class jwtServices {
    
    //clave secreta 
    private static final String secretKey="1CCxUrixg/pr/s2HjdRQ2gSC0oAWphH/XU3HTbRDKic=";
    
    public String getToken(UserDetails user) {
       
        return getToken(new HashMap<>(),user);
       
    }

    /*
     * Método para generar token
     * extraClaims los datos que se incluye en el token
     * se almacena el username
     * la fecha y hora de creación
     * la fecha y hora de expiración
     * firma del token y encriptación del token
     */
    public String getToken(Map<String,Object> extraClaims, UserDetails user){
        return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(user.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();

    }

    /*
     * Método para obtener la clave codificada
     */
    private Key getKey() {
        byte [] keyBytes=Decoders.BASE64.decode(secretKey);
       return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUserNameFromToken(String token) {
        //el userName se almacena en el Subject del token
       return getClaim(token,Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userdetails) {
        final String username=getUserNameFromToken(token);
        return (username.equals(userdetails.getUsername())&&
        !isTokenExpired(token));
        
    }

    private Claims getAllClaims(String token){
        return Jwts
        .parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }

    public <T> T getClaim(String token,Function<Claims,T>claimsResolver){
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        //método para recuperar la fecha de expiración del token
        return getClaim(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
    
    // private final IUsuario IUsuario;
    // //private jwtServices faltaaaaaaaa
    // //private final PasswordEncoder passwordEncoder;
    // private final AuthenticationManager authenticationManager;

    // public authResponse login(loginRequest request){
    //     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
    //     UserDetails user=IUsuario.findByUsername(request.getUserName()).orElseThrow();
    //     String token="";//faltaaaaaaa
    //     return authResponse.builder()
    //     .token(token)
    //     .build();
    // }
}
