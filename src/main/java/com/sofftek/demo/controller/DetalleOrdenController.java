package com.sofftek.demo.controller;

import com.sofftek.demo.entities.Detalle;
import com.sofftek.demo.entities.Producto;
import com.sofftek.demo.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetalleOrdenController {

    @Autowired
    DetalleService detalleService ;

    @CrossOrigin(origins = "*")
    @GetMapping("/detalles")
    public ResponseEntity<List<Detalle>> listarDetalles(@RequestParam(required=false, defaultValue="World")String name){
        List<Detalle> listado = detalleService.listarActivos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/detalles/page/{page}")
    public ResponseEntity<Page<Detalle>> listarDetallesPage(@PathVariable Integer page){

        Pageable pageable = PageRequest.of(page,2);

        Page<Detalle> listado = detalleService.listarActivos(pageable);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "detalle",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Detalle> insertarDetalle(@RequestBody Detalle detalleOrden) {
        Detalle detalleOrdenAInsertar = new Detalle();
        detalleOrdenAInsertar.setId(detalleOrden.getId());
        detalleOrdenAInsertar.setActivo(detalleOrden.getActivo());
        detalleOrdenAInsertar.setProducto(detalleOrden.getProducto());
        detalleOrdenAInsertar.setCantidad(detalleOrden.getCantidad());


        detalleService.insertar(detalleOrdenAInsertar);
        return new ResponseEntity<>(detalleOrden, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/detalle/{idDetalle}")
    public ResponseEntity<Detalle> modificarDetalle(@RequestBody Detalle detalleOrden){

        Detalle detalleAModificar = detalleService.buscarDetalleById(detalleOrden.getId());
        detalleAModificar.setCantidad(detalleOrden.getCantidad());
        detalleAModificar.setProducto(detalleOrden.getProducto());
        detalleAModificar.setActivo(detalleOrden.getActivo());
        detalleAModificar.setId(detalleOrden.getId());
        detalleService.modificar(detalleAModificar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/detalles/{idDetalle}")
    public ResponseEntity<Producto> eliminarDetalle(@PathVariable int idDetalle){
        detalleService.eliminar(idDetalle);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
