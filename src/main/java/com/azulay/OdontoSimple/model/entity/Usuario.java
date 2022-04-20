package com.azulay.OdontoSimple.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "username")
    @NotEmpty(message = "{campo.username.obrigatorio}")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "{campo.password.obrigatorio}")
    private String password;

}
