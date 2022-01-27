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

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/categorias")
    public List<Categoria> listarCategorias(){
        return categoriaService.listarActivos();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
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

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/categoria/{idCategoria}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable int idCategoria){
        categoriaService.eliminar(idCategoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/categoria/{idCategoria}")
    public ResponseEntity<Categoria> modificarCategoria(@RequestBody Categoria categoria){
        categoriaService.modificar(categoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@GetMapping("/clientes/agregar")
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
    }*/
}
