package com.ajnv.prestaBancoMonolitico.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "creditos")
@Getter
@Setter
public class CreditoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "rut")
    String rut;
    @Column(name = "estado")
    String estado;
    @Column(name = "tipo_prestamo")
    Integer tipoPrestamo; // 0 Remodelación, 1 primera vivienda, 2 segunda vivienda, 3 propiedades comerciales
    @Column(name = "plazo_maximo")
    Integer plazoMaximo;
    @Column(name = "tasa_int_minima")
    Double tasaIntMinima;
    @Column(name = "tasa_int_maxima")
    Double tasaIntMaxima;
    @Column(name = "monto_maximo")
    Integer montoMaximo;
}
