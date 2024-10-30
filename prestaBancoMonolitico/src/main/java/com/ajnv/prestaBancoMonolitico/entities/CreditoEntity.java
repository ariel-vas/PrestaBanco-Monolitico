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
    @Column(name = "plazo")
    Integer plazo;
    @Column(name = "tasa_interes")
    Double tasaInteres;
    @Column(name = "monto")
    Integer monto;
    // En adelante todos son: 0 no hay documento, 1 hay documento, 2 no se exige
    @Column(name = "comprobante_ingresos")
    Integer comprobanteIngresos;
    @Column(name = "certificado_avaluo")
    Integer certificadoAvaluo;
    @Column(name = "historial_crediticio")
    Integer historialCrediticio;
    @Column(name = "escritura_primera_vivienda")
    Integer escrituraPrimeraVivienda;
    @Column(name = "estado_financiero_negocio")
    Integer estadoFinancieroNegocio;
    @Column(name = "plan_negocios")
    Integer planNegocios;
    @Column(name = "presupuesto_remodelacion")
    Integer presupuestoRemodelacion;
    @Column(name = "certificado_avaluo_actualizado")
    Integer certificadoAvaluoActualizado;
}
