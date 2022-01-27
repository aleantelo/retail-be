package com.sofftek.demo.controller;


import com.sofftek.demo.entities.Usuario;
import com.sofftek.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarActivos();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(path = "usuario/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {
        if (usuario == null) {
            return new ResponseEntity<>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            usuarioService.insertar(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/usuario/{idUsuario}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int idUsuario){
        usuarioService.eliminar(idUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioAModificar = usuarioService.buscarUsuarioById(usuario.getId());
        usuarioAModificar.setNombreDeUsuario(usuario.getNombreDeUsuario());
        usuarioAModificar.setContraseña(usuario.getContraseña());
        usuarioAModificar.setActivo(usuario.getActivo());
        usuarioAModificar.setId(usuario.getId());
        usuarioService.modificar(usuarioAModificar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/usuarios/agregar")
    public String crearCliente() {
        return "Hola";
    }
}
