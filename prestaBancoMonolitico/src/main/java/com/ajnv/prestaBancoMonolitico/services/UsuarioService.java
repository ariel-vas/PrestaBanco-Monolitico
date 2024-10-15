package com.ajnv.prestaBancoMonolitico.services;

import com.ajnv.prestaBancoMonolitico.entities.UsuarioEntity;
import com.ajnv.prestaBancoMonolitico.models.CrearUsuario;
import com.ajnv.prestaBancoMonolitico.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public List<UsuarioEntity> getUsuarios() { return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> getUsuarioById(Integer id){ return usuarioRepository.findById(id); }

    public Optional<UsuarioEntity> getUsuarioByRut(String rut){ return usuarioRepository.findByRut(rut); }

    @Transactional
    public UsuarioEntity saveUsuario(CrearUsuario body){
        UsuarioEntity nuevoUsuario = new UsuarioEntity();

        nuevoUsuario.setRut(body.getRut());
        nuevoUsuario.setNombres(body.getNombres());
        nuevoUsuario.setApellidos(body.getApellidos());

        return usuarioRepository.save(nuevoUsuario);
    }

    public UsuarioEntity updateUsuario(String rutUsuario, UsuarioEntity nuevoUsuario){
        Optional<UsuarioEntity> usuarioOptional = Optional.ofNullable(usuarioRepository.findByRut(rutUsuario));
    }
}
