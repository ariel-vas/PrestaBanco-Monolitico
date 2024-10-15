package com.ajnv.prestaBancoMonolitico.repositories;

import com.ajnv.prestaBancoMonolitico.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query("SELECT u FROM usuarios where u.rut = :rut")
    UsuarioEntity findByRut(@Param("rut") String rut);

}