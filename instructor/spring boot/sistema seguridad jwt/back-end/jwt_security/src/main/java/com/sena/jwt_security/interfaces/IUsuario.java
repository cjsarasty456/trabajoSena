package com.sena.jwt_security.interfaces;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.jwt_security.models.seguridad.usuario;

public interface IUsuario extends JpaRepository<usuario, Integer> {
    Optional<usuario> findByUsername(String username);
}