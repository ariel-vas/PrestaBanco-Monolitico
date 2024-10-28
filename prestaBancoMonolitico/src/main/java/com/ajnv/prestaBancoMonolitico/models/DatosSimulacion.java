package com.ajnv.prestaBancoMonolitico.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DatosSimulacion {
    Double p; //Monto del préstamo
    Double a; //Tasa anual en porcentaje
    Double n; //Número total de pagos
}
