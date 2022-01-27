package com.sofftek.demo.controller;


import com.sofftek.demo.entities.*;
import com.sofftek.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "https://retailsoff-fe.herokuapp.com/")
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> listarProductos(@RequestParam(required=false, defaultValue="World")String name){
        List<Producto> listado = productoService.listarActivos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/productos/page/{page}")
    public ResponseEntity<Page<Producto>> listarProductosPage(@PathVariable Integer page){

        Pageable pageable = PageRequest.of(page,5);

        Page<Producto> listado = productoService.listarActivos(pageable);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @PostMapping(path = "producto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> insertarProducto(@Valid @RequestBody Producto producto) {
        System.out.println(producto.getNombre() + "-----------------------------------------");
        productoService.insertar(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @DeleteMapping("/productos/{idProducto}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable int idProducto){
        productoService.eliminar(idProducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
