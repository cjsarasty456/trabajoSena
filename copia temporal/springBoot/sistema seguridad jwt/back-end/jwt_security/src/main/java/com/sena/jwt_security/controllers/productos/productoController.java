package com.sena.jwt_security.controllers.productos;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/producto")
public class productoController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Home Método protegido",HttpStatus.OK);
      
    }
   
}
