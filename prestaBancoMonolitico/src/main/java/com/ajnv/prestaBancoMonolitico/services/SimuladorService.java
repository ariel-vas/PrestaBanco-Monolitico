package com.ajnv.prestaBancoMonolitico.services;

import com.ajnv.prestaBancoMonolitico.models.DatosSimulacion;
import org.springframework.stereotype.Service;

@Service
public class SimuladorService {
    public Double calculoCredito(DatosSimulacion body){
        double p = body.getP();
        double n = body.getN();
        double r = body.getA()/1200;

        double dividendo = r*Math.pow(1+r,n);
        double divisor = Math.pow(1+r,n)-1;
        return p*(dividendo/divisor);
    }
}
