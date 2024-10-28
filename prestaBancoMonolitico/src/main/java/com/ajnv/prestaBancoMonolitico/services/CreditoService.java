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

        nuevoCredito.setId(body.getId());
        nuevoCredito.setRut(body.getRut());
        nuevoCredito.setEstado(body.getEstado());
        nuevoCredito.setTipoPrestamo(body.getTipoPrestamo());
        nuevoCredito.setPlazoMaximo(body.getPlazoMaximo());
        nuevoCredito.setTasaIntMinima(body.getTasaIntMinima());
        nuevoCredito.setTasaIntMaxima(body.getTasaIntMaxima());
        nuevoCredito.setMontoMaximo(body.getMontoMaximo());

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
        if(nuevoCredito.getPlazoMaximo() != null){
            credito.setPlazoMaximo(nuevoCredito.getPlazoMaximo());
        }
        if(nuevoCredito.getTasaIntMinima() != null){
            credito.setTasaIntMinima(nuevoCredito.getTasaIntMinima());
        }
        if(nuevoCredito.getTasaIntMaxima() != null){
            credito.setTasaIntMaxima(nuevoCredito.getTasaIntMaxima());
        }
        if(nuevoCredito.getMontoMaximo() != null){
            credito.setMontoMaximo(nuevoCredito.getMontoMaximo());
        }

        return creditoRepository.save(credito);
    }

    public void deleteCredito(Integer id){creditoRepository.deleteById(id);}
}
