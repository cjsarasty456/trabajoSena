package com.sena.jwt.model.security;

import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="user")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class user implements UserDetails {

    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    @Column(name="id", nullable = false,length = 36)
    private String id;

    @Column(name="first_name", nullable = false,length = 30)
    private String first_name;

    @Column(name="last_name", nullable = false,length = 30)
    private String last_name;

    @Column(name="user_name", nullable = false,length = 100)
    private String user_name;

    @Column(name="password", nullable = false,length = 60)
    private String password;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private rol rol;

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.rol.getName()));
    }

    @Override
    public String getUsername() {
        return this.user_name;
    }
}
