package com.ajnv.prestaBancoMonolitico.controllers;

import com.ajnv.prestaBancoMonolitico.entities.UsuarioEntity;
import com.ajnv.prestaBancoMonolitico.models.CrearUsuario;
import com.ajnv.prestaBancoMonolitico.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {this.usuarioService = usuarioService;};

    @GetMapping("/usuarios")
    List<UsuarioEntity> getUsuarios() {return usuarioService.getUsuarios();}

    @GetMapping("/usuarios/{rutUsuario}")
    Optional<UsuarioEntity> getUsuarioByRUT(@PathVariable String rutUsuario){
        return usuarioService.getUsuarioByRut(rutUsuario);
    }

    @PostMapping("/usuarios")
    UsuarioEntity createUsuario(@RequestBody CrearUsuario body){
        System.out.println(body);
        return usuarioService.saveUsuario(body);
    }

    @PutMapping("/usuarios/{rutUsuario}")
    UsuarioEntity updateUsuario(@PathVariable String rutUsuario,
                                @RequestBody UsuarioEntity nuevoUsuario){
        return usuarioService.updateUsuario(rutUsuario, nuevoUsuario);
    }

    @DeleteMapping("/usuarios/{rutUsuario}")
    ResponseEntity<String> deleteUsuario(@PathVariable String rutUsuario){
        usuarioService.deleteUsuario(rutUsuario);
        return new ResponseEntity<>(
            "El usuario"+rutUsuario+"ha sido eliminado correctamente",
                HttpStatus.OK
        );
    }
}
