package com.sena.jwt_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sena.jwt_security.jwt.jwtAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig {

        // //versión 1
        // @Bean
        // public SecurityFilterChain SecurityFilterChain(
        //         HttpSecurity http) throws Exception {
        //     return http
        //             // para desactivar csrf
        //             .csrf(csrf -> csrf
        //                     .disable())
        //             .authorizeHttpRequests(authRequest -> authRequest
        //                     // indica que permite ingresar a las
        //                     // url que empiecen por public
        //                     // el resto es requerido autenticar
        //                     .requestMatchers("/api/v1/public/**").permitAll()
        //                     .anyRequest().authenticated())
        //                 .formLogin(withDefaults())
        //                 .build();
        // }

    public final jwtAuthenticationFilter jwtAuthenticationFilter;
    public final AuthenticationProvider authProvider;
    
    @Bean
    public SecurityFilterChain SecurityFilterChain(
            HttpSecurity http) throws Exception {
        return http
                // para desactivar csrf
                .csrf(csrf -> csrf
                        .disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        // indica que permite ingresar a las
                        // url que empiecen por public
                        // el resto es requerido autenticar
                        .requestMatchers("/api/v1/public/**").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(sessionManager->
                    sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authProvider)
                    .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    
    // @Bean
    // public SecurityFilterChain SecurityFilterChain(
    //         HttpSecurity http) throws Exception {
    //     return http
    //             // para desactivar csrf
    //             .csrf(csrf -> csrf
    //                     .disable())
    //             .authorizeHttpRequests(authRequest -> authRequest
    //                     // indica que permite ingresar a las
    //                     // url que empiecen por public
    //                     // el resto es requerido autenticar
    //                     .requestMatchers("/api/v1/public/**").permitAll()
    //                     .anyRequest().authenticated())
    //             .exceptionHandling(exceptionHandling -> exceptionHandling
    //                     .authenticationEntryPoint(unauthorizedEntryPoint())
    //                     .accessDeniedHandler(accessDeniedHandler()))
    //             .httpBasic(withDefaults())
    //             .build();
    // }

    private AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(403, "Forbidden");
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) 
        -> response.sendError(403, "Forbidden");
    }

 

}
