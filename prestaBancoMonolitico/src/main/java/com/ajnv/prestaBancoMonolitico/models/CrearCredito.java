package com.ajnv.prestaBancoMonolitico.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrearCredito {
    Integer id;
    String rut;
    String estado;
    Integer tipoPrestamo;
    Integer plazoMaximo;
    Double tasaIntMinima;
    Double tasaIntMaxima;
    Integer montoMaximo;
}
