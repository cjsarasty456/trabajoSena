package com.sena.jwt_security.jwt;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sena.jwt_security.services.jwt.jwtServices;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class jwtAuthenticationFilter extends OncePerRequestFilter {


    private final UserDetailsService userDetailsService;
    private final jwtServices jwtServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        //final String token=request.getHeader("Authorization");
        final String token=getTokenFromRequest(request);
        final String username;
        //condición si no hay token
        if(token==null){
            filterChain.doFilter(request, response);
            return;
        }
        //obtiene el userName del token
        username=jwtServices.getUserNameFromToken(token);
        
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userdetails=userDetailsService.loadUserByUsername(username);
            if(jwtServices.isTokenValid(token,userdetails)){
                UsernamePasswordAuthenticationToken authToken=new
                UsernamePasswordAuthenticationToken(
                    userdetails,
                    null,
                    userdetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        //obtener el header tipo Authorization
        final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
        //verificar si el header tiene Authorization y si empieza por el Bearer
        //que es el tipo de verificación utilizado para este ejercicio
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")){
            return authHeader.substring(7);
        }
        return null;
    }
    
}
