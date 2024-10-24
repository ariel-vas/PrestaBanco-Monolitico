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

    public Optional<UsuarioEntity> getUsuarioByRut(String rut){ return Optional.ofNullable(usuarioRepository.findByRut(rut)); }

    @Transactional
    public UsuarioEntity saveUsuario(CrearUsuario body){
        UsuarioEntity nuevoUsuario = new UsuarioEntity();

        nuevoUsuario.setRut(body.getRut());
        nuevoUsuario.setNombres(body.getNombres());
        nuevoUsuario.setApellidos(body.getApellidos());
        nuevoUsuario.setFecha_nacimiento(body.getFecha_nacimiento());
        nuevoUsuario.setGenero(body.getGenero());
        nuevoUsuario.setProfesion(body.getProfesion());
        nuevoUsuario.setDireccion(body.getDireccion());
        nuevoUsuario.setComuna(body.getComuna());
        nuevoUsuario.setCiudad(body.getCiudad());
        nuevoUsuario.setCorreo(body.getCorreo());
        nuevoUsuario.setTelefono(body.getTelefono());

        return usuarioRepository.save(nuevoUsuario);
    }

    public UsuarioEntity updateUsuario(String rutUsuario, UsuarioEntity nuevoUsuario){
        Optional<UsuarioEntity> usuarioOptional = Optional.ofNullable(usuarioRepository.findByRut(rutUsuario));

        if(usuarioOptional.isEmpty()){
            throw new RuntimeException("El usuario "+rutUsuario+" no existe.");
        }

        UsuarioEntity usuario = usuarioOptional.get();

        if(nuevoUsuario.getId() != null){
            usuario.setId(nuevoUsuario.getId());
        }
        if(nuevoUsuario.getRut() != null){
            usuario.setRut(nuevoUsuario.getRut());
        }
        if(nuevoUsuario.getNombres() != null){
            usuario.setNombres(nuevoUsuario.getNombres());
        }
        if(nuevoUsuario.getApellidos() != null){
            usuario.setApellidos(nuevoUsuario.getApellidos());
        }
        if(nuevoUsuario.getFecha_nacimiento() != null){
            usuario.setFecha_nacimiento(nuevoUsuario.getFecha_nacimiento());
        }
        if(nuevoUsuario.getGenero() != null){
            usuario.setGenero(nuevoUsuario.getGenero());
        }
        if(nuevoUsuario.getProfesion() != null){
            usuario.setProfesion(nuevoUsuario.getProfesion());
        }
        if(nuevoUsuario.getDireccion() != null){
            usuario.setDireccion(nuevoUsuario.getDireccion());
        }
        if(nuevoUsuario.getComuna() != null){
            usuario.setComuna(nuevoUsuario.getComuna());
        }
        if(nuevoUsuario.getCiudad() != null){
            usuario.setCiudad(nuevoUsuario.getCiudad());
        }
        if(nuevoUsuario.getCorreo() != null){
            usuario.setCorreo(nuevoUsuario.getCorreo());
        }
        if(nuevoUsuario.getTelefono() != null){
            usuario.setTelefono(nuevoUsuario.getTelefono());
        }

        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String rut) {usuarioRepository.deleteByRut(rut);}
}
