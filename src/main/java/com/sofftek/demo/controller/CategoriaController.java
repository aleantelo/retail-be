package com.sofftek.demo.controller;


import com.sofftek.demo.entities.Categoria;
import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.TipoDeCliente;
import com.sofftek.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @CrossOrigin(origins = "*")
    @GetMapping("/categorias")
    public List<Categoria> listarCategorias(){
        return categoriaService.listarActivos();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "categorias",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> insertarCategoria(@RequestBody Categoria categoria) {
        if (categoria == null) {
            return new ResponseEntity<>(categoria, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            categoriaService.insertar(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.CREATED);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/categoria/{idCategoria}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable int idCategoria){
        categoriaService.eliminar(idCategoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/categoria/{idCategoria}")
    public ResponseEntity<Categoria> modificarCategoria(@RequestBody Categoria categoria){
        categoriaService.modificar(categoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
