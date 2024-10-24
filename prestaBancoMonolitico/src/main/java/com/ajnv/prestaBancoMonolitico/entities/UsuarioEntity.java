package com.ajnv.prestaBancoMonolitico.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    @Column(name = "fecha_nacimiento")
    Date fecha_nacimiento;

    @Column(name = "genero")
    Integer genero; // 0 mujer, 1 hombre, 2 prefiero no decirlo

    @Column(name = "estado_civil")
    String estado_civil;

    @Column(name = "profesion")
    String profesion;

    @Column(name = "direccion")
    String direccion;

    @Column(name = "comuna")
    String comuna;

    @Column(name = "ciudad")
    String ciudad;

    @Column(name = "correo")
    String correo;

    @Column(name = "telefono")
    Integer telefono;
}
