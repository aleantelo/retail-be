package com.sofftek.demo.controller;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Proveedor;
import com.sofftek.demo.entities.TipoDeCliente;
import com.sofftek.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @CrossOrigin(origins = "*")
    @GetMapping("/proveedores")
    public List<Proveedor> listarProveedores(){

        return proveedorService.listarActivos();

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "proveedor",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proveedor> insertarProveedor(@RequestBody Proveedor proveedor) {
        if (proveedor == null) {
            return new ResponseEntity<>(proveedor, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            proveedorService.insertar(proveedor);
            return new ResponseEntity<>(proveedor, HttpStatus.CREATED);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/proveedor/{idProveedor}")
    public ResponseEntity<Cliente> eliminarProveedor(@PathVariable int idProveedor){
        proveedorService.eliminar(idProveedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/proveedor/{idProveedor}")
    public ResponseEntity<Cliente> modificarProveedor(@RequestBody Proveedor proveedor){
        proveedorService.modificar(proveedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
