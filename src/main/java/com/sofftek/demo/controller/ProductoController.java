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

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> listarProductos(@RequestParam(required=false, defaultValue="World")String name){
        List<Producto> listado = productoService.listarActivos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/productos/page/{page}")
    public ResponseEntity<Page<Producto>> listarProductosPage(@PathVariable Integer page){

        Pageable pageable = PageRequest.of(page,5);

        Page<Producto> listado = productoService.listarActivos(pageable);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(path = "producto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> insertarProducto(@Valid @RequestBody Producto producto) {
        System.out.println(producto.getNombre() + "-----------------------------------------");
        productoService.insertar(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/productos/{idProducto}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable int idProducto){
        productoService.eliminar(idProducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/producto/{idProducto}")
    public ResponseEntity<Producto> modificarProducto(@RequestBody Producto producto){

        Producto productoAModificar = productoService.buscarProductoById(producto.getId());
        productoAModificar.setActivo(producto.getActivo());
        productoAModificar.setId(producto.getId());
        productoAModificar.setProveedor(producto.getProveedor());
        productoAModificar.setNombre(producto.getNombre());
        productoAModificar.setCategoria(producto.getCategoria());
        productoAModificar.setPromocionProductos(producto.getPromocionProductos());
        productoAModificar.setStock(producto.getStock());
        productoAModificar.setPrecioUnitario(producto.getPrecioUnitario());

        productoService.modificar(productoAModificar);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
