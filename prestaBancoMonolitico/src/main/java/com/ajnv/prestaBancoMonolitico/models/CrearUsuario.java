package com.ajnv.prestaBancoMonolitico.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CrearUsuario {
    String rut;
    String nombres;
    String apellidos;
    Date fecha_nacimiento;
    Integer genero;
    String estado_civil;
    String profesion;
    String direccion;
    String comuna;
    String ciudad;
    String correo;
    Integer telefono;
}
