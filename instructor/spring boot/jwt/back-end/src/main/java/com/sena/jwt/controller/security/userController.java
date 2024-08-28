package com.sena.jwt.controller.security;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.jwt.model.security.user;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class userController {

    @GetMapping("/profile/")
    public ResponseEntity<user> getProfile() {
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        user user=(user) auth.getPrincipal();
        return new ResponseEntity<user>(user,HttpStatus.OK);
    }

}
