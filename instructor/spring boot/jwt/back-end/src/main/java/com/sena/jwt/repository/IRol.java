package com.sena.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.jwt.model.security.rol;




@Repository
public interface IRol extends JpaRepository<rol,String> {

    @Query("SELECT r FROM rol r WHERE r.name='user'")
    public rol getRolDefault();


}
