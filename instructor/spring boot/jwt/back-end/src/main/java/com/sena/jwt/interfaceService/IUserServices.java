package com.sena.jwt.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.jwt.model.security.authResponse;
import com.sena.jwt.model.security.registerRequest;
import com.sena.jwt.model.security.user;

public interface IUserServices {

    public authResponse register(registerRequest request);
    public Optional<user> findByUsername(String userName);
    public int delete(String id);
    public List<user> findAll();

}
