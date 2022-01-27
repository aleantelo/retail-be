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

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarActivos();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
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

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/cliente/{idCliente}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable int idCliente){
        clienteService.eliminar(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/cliente/{idCliente}")
    public ResponseEntity<Cliente> modificarCliente(@RequestBody Cliente cliente){
        clienteService.modificar(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/clientes/agregar")
    public String crearCliente() {
        Cliente cliente = new Cliente();
        cliente.setTipoDeCliente(TipoDeCliente.EMPRESA);
        cliente.setApellido("Antelo");
        cliente.setNombre("Alejandro");
        cliente.setDni(37803270);
        cliente.setRazon_social("Empresita");
        clienteService.insertar(cliente);

        Cliente clientee = new Cliente();
        clientee.setTipoDeCliente(TipoDeCliente.PARTICULAR);
        clientee.setApellido("Jauregui");
        clientee.setNombre("Lucia");
        clientee.setDni(39107509);
        clientee.setRazon_social("Parti");
        clienteService.insertar(clientee);
        return "Clientes Creados";
        }
    }


