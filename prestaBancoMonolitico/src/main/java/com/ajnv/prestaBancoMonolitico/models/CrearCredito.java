package com.ajnv.prestaBancoMonolitico.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrearCredito {
    String rut;
    String estado;
    Integer tipoPrestamo;
    Integer plazo;
    Double tasaInteres;
    Integer monto;
}
