package com.ajnv.prestaBancoMonolitico.controllers;

import com.ajnv.prestaBancoMonolitico.entities.CreditoEntity;
import com.ajnv.prestaBancoMonolitico.models.CrearCredito;
import com.ajnv.prestaBancoMonolitico.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CreditoController {

    CreditoService creditoService;

    @Autowired
    public CreditoController(CreditoService creditoService){this.creditoService = creditoService;}

    @GetMapping("/creditos")
    List<CreditoEntity> getCreditos(){return creditoService.getCreditos();}

    @GetMapping("/creditos/{idCredito}")
    Optional<Optional<CreditoEntity>> getCreditoById(@PathVariable Integer idCredito){
        return creditoService.getCreditoByID(idCredito);
    }

    @GetMapping("/credutos/{rutUsuario}")
    Optional<List<CreditoEntity>> getCreditosByRut(@PathVariable String rutUsuario){
        return creditoService.getCreditoByRut(rutUsuario);
    }

    @PostMapping("/creditos")
    CreditoEntity createCredito(@RequestBody CrearCredito body){
        System.out.println(body);
        return creditoService.saveCredito(body);
    }

    @PutMapping("/creditos/{idCredito}")
    CreditoEntity updateCredito(@PathVariable Integer idCredito,
                                @RequestBody CreditoEntity nuevoCredito){
        return creditoService.updateCredito(idCredito, nuevoCredito);
    }

    @DeleteMapping("/creditos/{idCredito}")
    ResponseEntity<String> deleteCredito(@PathVariable Integer idCredito){
        creditoService.deleteCredito(idCredito);
        return new ResponseEntity<>(
                "El crédito "+idCredito+" fue eliminado correctamente.",
                HttpStatus.OK
        );
    }
}
