package com.sofftek.demo.controller;


import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){

        List<Empleado> empleados = empleadoService.listarActivos();

         return empleados;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(path = "empleado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> insertarEmpleado(@RequestBody Empleado empleado) {
        if (empleado == null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            empleadoService.insertar(empleado);
            return new ResponseEntity<>(empleado, HttpStatus.CREATED);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/empleado/{idEmpleado}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable int idEmpleado){
        empleadoService.eliminar(idEmpleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/empleado/{idEmpleado}")
    public ResponseEntity<Empleado> modificarEmpleado(@RequestBody Empleado empleado){
        empleadoService.modificar(empleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/empleado/agregar")
    public String agregarEmpleado(){
        Empleado empleado = new Empleado();
        empleado.setApellido("Ramirez");
        empleado.setNombre("Pepe");
        empleadoService.insertar(empleado);

        Empleado empleado1 = new Empleado();
        empleado1.setApellido("Ramirez");
        empleado1.setNombre("Pepe");
        empleado1.setSupervisor(empleado);
        empleadoService.insertar(empleado1);
        return "Empleados creados";
    }
}
