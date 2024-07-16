package com.sena.jwt_security.models.seguridad;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="usuarios")
public class usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario", nullable = false)
    private Integer idUsuario;
    
    @Column(name="user_name", nullable = false, unique = true )
    private String username;

    @Column( name="password", nullable = false)
    private String password;

    @Column(name="email", nullable = false,  unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    rol rol;
    
    //método que retorna el nombre del rol del usuario
      @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((rol.name())));
    }
    /*
     * Método que indica si la cuenta no expira
     */
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    /*
     * Método que indica si la cuenta no se bloquea
     */
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    /*
     * Método que indica si las credenciales no expira
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    /*
     * Método que indica si la cuenta está activa
     */

    @Override
    public boolean isEnabled() {
        return true;
    }

}
