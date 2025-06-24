package com.sena.jwt.controller.security;

import lombok.RequiredArgsConstructor;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.jwt.model.security.rol;
import com.sena.jwt.model.security.user;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class userController {

    private user getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (user) auth.getPrincipal();
    }

    private rol getRol() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user user= (user) auth.getPrincipal();
        return user.getRol();
    }

    @GetMapping("/profile/")
    public ResponseEntity<user> getProfile() {
        user user = getUser();
        return new ResponseEntity<user>(user, HttpStatus.OK);
    }

    @GetMapping("/admin/findAll/")
    public ResponseEntity<String> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var user= (user) auth.getPrincipal();
        if (!user.getRol().isAdmin())
            return new ResponseEntity<String>("No tienes permiso", HttpStatus.FORBIDDEN);

        return new ResponseEntity<String>("Métdo administrador", HttpStatus.OK);
    }

}
