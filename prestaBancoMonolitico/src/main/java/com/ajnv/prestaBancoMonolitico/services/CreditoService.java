package com.ajnv.prestaBancoMonolitico.services;

import com.ajnv.prestaBancoMonolitico.entities.CreditoEntity;
import com.ajnv.prestaBancoMonolitico.models.CrearCredito;
import com.ajnv.prestaBancoMonolitico.repositories.CreditoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    CreditoRepository creditoRepository;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository){this.creditoRepository = creditoRepository;}

    public List<CreditoEntity> getCreditos() {return creditoRepository.findAll();}

    public Optional<Optional<CreditoEntity>> getCreditoByID(Integer id){return Optional.of(creditoRepository.findById(id));}

    public Optional<List<CreditoEntity>> getCreditoByRut(String rut){
        return Optional.ofNullable(creditoRepository.findByRut(rut));
    }

    @Transactional
    public CreditoEntity saveCredito(CrearCredito body){
        CreditoEntity nuevoCredito = new CreditoEntity();

        nuevoCredito.setRut(body.getRut());
        nuevoCredito.setEstado("En revisión inicial");
        nuevoCredito.setPlazo(body.getPlazo());
        nuevoCredito.setTasaInteres(body.getTasaInteres());
        nuevoCredito.setMonto(body.getMonto());

        Integer tp = body.getTipoPrestamo();
        nuevoCredito.setTipoPrestamo(tp);
        if(tp == 0){
            nuevoCredito.setComprobanteIngresos(0);
            nuevoCredito.setCertificadoAvaluo(2);
            nuevoCredito.setHistorialCrediticio(2);
            nuevoCredito.setEscrituraPrimeraVivienda(2);
            nuevoCredito.setEstadoFinancieroNegocio(2);
            nuevoCredito.setPlanNegocios(2);
            nuevoCredito.setPresupuestoRemodelacion(0);
            nuevoCredito.setCertificadoAvaluoActualizado(0);
        }
        if(tp == 1){
            nuevoCredito.setComprobanteIngresos(0);
            nuevoCredito.setCertificadoAvaluo(0);
            nuevoCredito.setHistorialCrediticio(0);
            nuevoCredito.setEscrituraPrimeraVivienda(2);
            nuevoCredito.setEstadoFinancieroNegocio(2);
            nuevoCredito.setPlanNegocios(2);
            nuevoCredito.setPresupuestoRemodelacion(2);
            nuevoCredito.setCertificadoAvaluoActualizado(2);
        }
        if(tp == 2){
            nuevoCredito.setComprobanteIngresos(0);
            nuevoCredito.setCertificadoAvaluo(0);
            nuevoCredito.setHistorialCrediticio(0);
            nuevoCredito.setEscrituraPrimeraVivienda(0);
            nuevoCredito.setEstadoFinancieroNegocio(2);
            nuevoCredito.setPlanNegocios(2);
            nuevoCredito.setPresupuestoRemodelacion(2);
            nuevoCredito.setCertificadoAvaluoActualizado(2);
        }
        if(tp == 3){
            nuevoCredito.setComprobanteIngresos(0);
            nuevoCredito.setCertificadoAvaluo(0);
            nuevoCredito.setHistorialCrediticio(2);
            nuevoCredito.setEscrituraPrimeraVivienda(2);
            nuevoCredito.setEstadoFinancieroNegocio(0);
            nuevoCredito.setPlanNegocios(0);
            nuevoCredito.setPresupuestoRemodelacion(2);
            nuevoCredito.setCertificadoAvaluoActualizado(2);
        }

        return creditoRepository.save(nuevoCredito);
    }

    public CreditoEntity updateCredito(Integer idCredito, CreditoEntity nuevoCredito){
        Optional<CreditoEntity> creditoOptional = creditoRepository.findById(idCredito);

        if(creditoOptional.isEmpty()){
            throw new RuntimeException("El crédito "+idCredito+" no existe.");
        }

        CreditoEntity credito = creditoOptional.get();

        if(nuevoCredito.getId() != null){
            credito.setId(nuevoCredito.getId());
        }
        if(nuevoCredito.getRut() != null){
            credito.setRut(nuevoCredito.getRut());
        }
        if(nuevoCredito.getEstado() != null){
            credito.setEstado(nuevoCredito.getEstado());
        }
        if(nuevoCredito.getTipoPrestamo() != null){
            credito.setTipoPrestamo(nuevoCredito.getTipoPrestamo());
        }
        if(nuevoCredito.getPlazo() != null){
            credito.setPlazo(nuevoCredito.getPlazo());
        }
        if(nuevoCredito.getTasaInteres() != null){
            credito.setTasaInteres(nuevoCredito.getTasaInteres());
        }
        if(nuevoCredito.getMonto() != null){
            credito.setMonto(nuevoCredito.getMonto());
        }
        if(nuevoCredito.getComprobanteIngresos() != null){
            credito.setComprobanteIngresos(nuevoCredito.getComprobanteIngresos());
        }
        if(nuevoCredito.getCertificadoAvaluo() != null){
            credito.setCertificadoAvaluo(nuevoCredito.getCertificadoAvaluo());
        }
        if(nuevoCredito.getHistorialCrediticio() != null){
            credito.setHistorialCrediticio(nuevoCredito.getHistorialCrediticio());
        }
        if(nuevoCredito.getEscrituraPrimeraVivienda() != null){
            credito.setEscrituraPrimeraVivienda(nuevoCredito.getEscrituraPrimeraVivienda());
        }
        if(nuevoCredito.getEstadoFinancieroNegocio() != null){
            credito.setEstadoFinancieroNegocio(nuevoCredito.getEstadoFinancieroNegocio());
        }
        if(nuevoCredito.getPlanNegocios() != null){
            credito.setPlanNegocios(nuevoCredito.getPlanNegocios());
        }
        if(nuevoCredito.getPresupuestoRemodelacion() != null){
            credito.setPresupuestoRemodelacion(nuevoCredito.getPresupuestoRemodelacion());
        }
        if(nuevoCredito.getCertificadoAvaluoActualizado() != null){
            credito.setCertificadoAvaluoActualizado(nuevoCredito.getCertificadoAvaluoActualizado());
        }

        return creditoRepository.save(credito);
    }

    public void deleteCredito(Integer id){creditoRepository.deleteById(id);}
}
