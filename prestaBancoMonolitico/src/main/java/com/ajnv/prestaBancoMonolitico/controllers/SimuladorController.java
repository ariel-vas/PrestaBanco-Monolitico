package com.ajnv.prestaBancoMonolitico.controllers;

import com.ajnv.prestaBancoMonolitico.models.DatosSimulacion;
import com.ajnv.prestaBancoMonolitico.services.SimuladorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimuladorController {

    SimuladorService simuladorService;

    public SimuladorController(SimuladorService simuladorService){ this.simuladorService = simuladorService;}

    @GetMapping("/res_simulacion")
    Double getResultadoSimulacion(@RequestBody DatosSimulacion body){
        return simuladorService.calculoCredito(body);
    }
}
