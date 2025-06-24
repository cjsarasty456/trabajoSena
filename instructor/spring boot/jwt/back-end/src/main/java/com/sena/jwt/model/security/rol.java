package com.sena.jwt.model.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="rol")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class rol {

    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    @Column(name="id", nullable = false,length = 36)
    private String id;

    @Column(name="name", nullable = false,length = 30, unique = true)
    private String name;

    @Column(name="state", nullable = false)
    private int state;

    @Column(name="admin", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean admin;
    
}
