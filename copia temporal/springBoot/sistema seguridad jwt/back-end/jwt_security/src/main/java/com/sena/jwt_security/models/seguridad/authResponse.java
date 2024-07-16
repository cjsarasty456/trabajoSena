package com.sena.jwt_security.models.seguridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class authResponse {
    /*
      Esta clase retorna el token, que tiene
      el usuario al momento de autenticarse
     */
    String token;
}
