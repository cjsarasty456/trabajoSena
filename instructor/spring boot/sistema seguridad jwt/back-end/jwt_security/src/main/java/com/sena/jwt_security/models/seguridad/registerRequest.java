package com.sena.jwt_security.models.seguridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class registerRequest {

    /*
     * Clase que almacena la petición
     * de registro
     */
    String userName;
    String password;
    String email;
}
