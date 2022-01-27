package com.sofftek.demo.controller;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Promocion;
import com.sofftek.demo.entities.TipoDeCliente;
import com.sofftek.demo.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PromocionController {


    @Autowired
    private PromocionService promocionService;

    @CrossOrigin(origins = "*")
    @GetMapping("/promociones")
    public List<Promocion> listarPromociones(){
        return promocionService.listarActivos();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "promocion/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Promocion> insertarPromocion(@RequestBody Promocion promocion) {
        if (promocion == null) {
            return new ResponseEntity<>(promocion, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            promocionService.insertar(promocion);
            return new ResponseEntity<>(promocion, HttpStatus.CREATED);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/promocion/{idPromocion}")
    public ResponseEntity<Promocion> eliminarPromocion(@PathVariable int idPromocion){
        promocionService.eliminar(idPromocion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/promocion/{idPromocion}")
    public ResponseEntity<Promocion> modificarPromocion(@RequestBody Promocion promocion){
        promocionService.modificar(promocion);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
