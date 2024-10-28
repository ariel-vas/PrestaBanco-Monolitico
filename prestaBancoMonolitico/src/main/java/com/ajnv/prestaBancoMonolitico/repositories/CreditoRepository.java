package com.ajnv.prestaBancoMonolitico.repositories;

import com.ajnv.prestaBancoMonolitico.entities.CreditoEntity;
import com.ajnv.prestaBancoMonolitico.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditoRepository extends JpaRepository<CreditoEntity, Integer> {

    List<CreditoEntity> findByRut(@Param("rut") String rut);
}
