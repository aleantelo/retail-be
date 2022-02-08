package com.sofftek.demo.controller;


import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.Usuario;
import com.sofftek.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> listarEmpleados(@RequestParam(required=false, defaultValue="World")String name){
        List<Empleado> empleados = empleadoService.listarActivos();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping(path = "empleado",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> insertarEmpleado(@RequestBody Empleado empleado) {
        System.out.println("APELLIDO: " + empleado.getApellido());
        System.out.println("Nombre de Usuario: " + empleado.getUsuario().getNombreDeUsuario());
        System.out.println("CONTRASEÑA: " + empleado.getUsuario().getContraseña());
        System.out.println("NOMBRE " + empleado.getNombre());
        System.out.println("ACTIVO" + empleado.getUsuario().getActivo());



        Empleado emple = new Empleado();
            Usuario usuarioAInsertar = new Usuario();
            usuarioAInsertar.setContraseña(empleado.getUsuario().getContraseña());
            usuarioAInsertar.setNombreDeUsuario(empleado.getUsuario().getNombreDeUsuario());
            if(empleado.getUsuario().getTipoDeUsuario() == "ADMIN"){
                usuarioAInsertar.setTipoDeUsuario(empleado.getUsuario().getTipoDeUsuario());
            }
            emple.setUsuario(usuarioAInsertar);
            emple.setApellido(empleado.getApellido());
            emple.setNombre(empleado.getNombre());

            empleadoService.insertar(emple);
            return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }

    @DeleteMapping("/empleado/{idEmpleado}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable int idEmpleado){
        empleadoService.eliminar(idEmpleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/empleado/{idEmpleado}")
    public ResponseEntity<Empleado> modificarEmpleado(@RequestBody Empleado empleado){
        empleadoService.modificar(empleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/empleado/agregar")
    public String agregarEmpleado(){
        Usuario usuario = new Usuario();
        usuario.setNombreDeUsuario("Mijuky");
        usuario.setContraseña("34252031");
        usuario.setTipoDeUsuario("Admin");
        Empleado empleado = new Empleado();
        empleado.setApellido("Ramirez");
        empleado.setNombre("Pepe");
        empleado.setUsuario(usuario);

        empleadoService.insertar(empleado);
        return "Empleados creados";
    }
}
