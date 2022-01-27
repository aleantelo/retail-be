package com.sofftek.demo.controller;

import com.sofftek.demo.entities.*;
import com.sofftek.demo.service.DetalleService;
import com.sofftek.demo.service.OrdenService;
import com.sofftek.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class OrdenController {

    @Autowired
    ProductoService productoService;

    @Autowired
    DetalleService detalleService;

    @Autowired
    OrdenService ordenService;

    @GetMapping("/ordenes")
    public ResponseEntity<List<Orden>> listarOrdenes(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("ESTOY ENTRANDO AL CONTROLLER DE ORDENES");
        List<Orden> listado = ordenService.listarActivos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/ordenes/page/{page}")
    public ResponseEntity<Page<Orden>> listarOrdenesPorPage(@PathVariable Integer page) {

        Pageable pageable = PageRequest.of(page, 2);

        Page<Orden> listado = ordenService.listarActivos(pageable);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @PostMapping(path = "orden")
    public String insertarOrden(@RequestBody List<Detalle> detalles) {

        Producto produ = new Producto();
        Set<Detalle> detallesAInsertar = new HashSet<>();
        Detalle detalleAInsertar = new Detalle();
        Orden ordenAInsertar = new Orden();
        for (Detalle detalle : detalles) {
            produ.setId(detalle.getProducto().getId());
            produ.setActivo(detalle.getProducto().getActivo());
            produ.setPrecioUnitario(detalle.getProducto().getPrecioUnitario());
            produ.setNombre(detalle.getProducto().getNombre());
            produ.setStock(detalle.getProducto().getStock());
            detalleAInsertar.setCantidad((detalle.getCantidad()));
            detalleAInsertar.setProducto(produ);
            detallesAInsertar.add(detalleAInsertar);
        }
        ordenAInsertar.agregarDetalles(detallesAInsertar);

        ordenService.insertar(ordenAInsertar);

        return "CREADO";
    }

    @DeleteMapping("/ordenes/{idOrden}")
    public ResponseEntity<Orden> eliminarOrden(@PathVariable int idOrden) {
        ordenService.eliminar(idOrden);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/orden/{idOrden}")
    public ResponseEntity<Orden> modificarOrden(@RequestBody Orden orden) {
        Set<Detalle> detalles = new HashSet<>();
        Producto produ;
        Detalle detalleAModificar;
        for (Detalle detalle : orden.getDetalles()) {
            produ = productoService.buscarProductoById(detalle.getProducto().getId());
            produ.setPrecioUnitario(detalle.getProducto().getPrecioUnitario());
            produ.setProveedor(detalle.getProducto().getProveedor());
            produ.setStock(detalle.getProducto().getStock());
            produ.setNombre(detalle.getProducto().getNombre());
            produ.setActivo(detalle.getProducto().getActivo());
            produ.setId(detalle.getProducto().getId());
            produ.setCategoria(detalle.getProducto().getCategoria());
            produ.setPromocionProductos(detalle.getProducto().getPromocionProductos());
            detalleAModificar = detalleService.buscarDetalleById(detalle.getId());
            detalleAModificar.setProducto(produ);
            detalleAModificar.setActivo(detalle.getActivo());
            detalleAModificar.setId(detalle.getId());
            detalleAModificar.setCantidad(detalle.getCantidad());
            detalles.add(detalleAModificar);
        }
        Orden ordenAModificar = new Orden();
        ordenAModificar.setActivo(orden.getActivo());
        ordenAModificar.setDetalles(detalles);
        ordenAModificar.setCliente(orden.getCliente());
        ordenAModificar.setEstado(orden.getEstado());
        ordenAModificar.setVendedor(orden.getVendedor());
        ordenAModificar.setFechaDeEntrega(orden.getFechaDeEntrega());
        ordenAModificar.setFechaGenerada(orden.getFechaGenerada());
        ordenAModificar.setId(orden.getId());

        ordenService.modificar(ordenAModificar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}