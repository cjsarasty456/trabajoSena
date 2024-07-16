package com.sena.jwt.controller.security;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class userController {

    @GetMapping("/profile/")
    public ResponseEntity<String> getProfile() {
        return new ResponseEntity<>("end-point privado profile",HttpStatus.OK);
    }

}
