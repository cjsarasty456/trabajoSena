package com.sena.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.jwt.model.security.user;
import java.util.Optional;


@Repository
public interface IUser extends JpaRepository<user,String> {

    @Query("SELECT u FROM user u WHERE u.user_name=?1 ")
    Optional<user> findByUsername(String username);

    @Query("SELECT u FROM user u JOIN u.rol r WHERE u.id=?1 AND r.admin=true ")
    Optional<user> findByAdmin(String id);

}
