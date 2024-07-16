package com.sena.jwt.model.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registerRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
