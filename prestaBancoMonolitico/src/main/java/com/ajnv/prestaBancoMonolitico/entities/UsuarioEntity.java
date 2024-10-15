package com.ajnv.prestaBancoMonolitico.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "rut")
    String rut;

    @Column(name = "nombres")
    String nombres;

    @Column(name = "apellidos")
    String apellidos;
}
