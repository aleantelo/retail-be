package com.sofftek.demo.controller;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.TipoDeCliente;
import com.sofftek.demo.service.ClienteService;
import com.sofftek.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarActivos();
    }

    @PostMapping(path = "cliente",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
        if (cliente == null) {
            return new ResponseEntity<>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            clienteService.insertar(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/cliente/{idCliente}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable int idCliente){
        clienteService.eliminar(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cliente/{idCliente}")
    public ResponseEntity<Cliente> modificarCliente(@RequestBody Cliente cliente){
        clienteService.modificar(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    }


