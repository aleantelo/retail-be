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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class OrdenController {

    @Autowired
    ProductoService productoService;

    @Autowired
    DetalleService detalleService;

    @Autowired
    OrdenService ordenService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/ordenes")
    public ResponseEntity<List<Orden>> listarOrdenes(@RequestParam(required=false, defaultValue="World")String name){
        System.out.println("ESTOY ENTRANDO AL CONTROLLER DE ORDENES");
        List<Orden> listado = ordenService.listarActivos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/ordenes/page/{page}")
    public ResponseEntity<Page<Orden>> listarOrdenesPorPage(@PathVariable Integer page){

        Pageable pageable = PageRequest.of(page,2);

        Page<Orden> listado = ordenService.listarActivos(pageable);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(path = "orden")
    public String insertarOrden( @RequestParam Map<String,String> lista) {
        System.out.println("DETALLE" + lista.get("detalle"));
        System.out.println("CANTIDAD" + lista.get("cantidad"));

        Set<Detalle> detalles = new HashSet<>();
        Producto produ;
        Detalle detalleAInsertarEnOrden;
        /*for(Detalle detalle:orden.getDetalles()){
            produ = productoService.buscarProductoById(detalle.getProducto().getId());
            produ.setPrecioUnitario(detalle.getProducto().getPrecioUnitario());
            produ.setProveedor(detalle.getProducto().getProveedor());
            produ.setStock(detalle.getProducto().getStock());
            produ.setNombre(detalle.getProducto().getNombre());
            produ.setActivo(detalle.getProducto().getActivo());
            produ.setId(detalle.getProducto().getId());
            produ.setCategoria(detalle.getProducto().getCategoria());
            produ.setPromocionProductos(detalle.getProducto().getPromocionProductos());
            detalleAInsertarEnOrden = detalleService.buscarDetalleById(detalle.getId());
            detalleAInsertarEnOrden.setProducto(produ);
            detalleAInsertarEnOrden.setActivo(detalle.getActivo());
            detalleAInsertarEnOrden.setId(detalle.getId());
            detalleAInsertarEnOrden.setCantidad(detalle.getCantidad());
            detalles.add(detalleAInsertarEnOrden);
        }

        Orden ordenAInsertar = new Orden();
        ordenAInsertar.setActivo(orden.getActivo());
        ordenAInsertar.setDetalles(detalles);
        ordenAInsertar.setCliente(orden.getCliente());
        ordenAInsertar.setEstado(orden.getEstado());
        ordenAInsertar.setVendedor(orden.getVendedor());
        ordenAInsertar.setFechaDeEntrega(orden.getFechaDeEntrega());
        ordenAInsertar.setFechaGenerada(orden.getFechaGenerada());
        ordenAInsertar.setId(orden.getId());

        ordenService.insertar(ordenAInsertar);*/

        return  "CREADO";
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/ordenes/{idOrden}")
    public ResponseEntity<Orden> eliminarOrden(@PathVariable int idOrden){
        ordenService.eliminar(idOrden);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/orden/{idOrden}")
    public ResponseEntity<Orden> modificarOrden(@RequestBody Orden orden){
        Set<Detalle> detalles = new HashSet<>();
        Producto produ;
        Detalle detalleAModificar;
        for(Detalle detalle:orden.getDetalles()){
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
        ordenAModificar .setCliente(orden.getCliente());
        ordenAModificar.setEstado(orden.getEstado());
        ordenAModificar.setVendedor(orden.getVendedor());
        ordenAModificar.setFechaDeEntrega(orden.getFechaDeEntrega());
        ordenAModificar.setFechaGenerada(orden.getFechaGenerada());
        ordenAModificar.setId(orden.getId());

        ordenService.modificar(ordenAModificar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/ordenes/agregar")
    public void agregarOrden(@RequestParam(required=false, defaultValue="World")String name){

        Producto producto = new Producto();
        producto.setStock(200);
        producto.setNombre("pantalon");
        producto.setPrecioUnitario(200);

        Detalle detalleOrden  = new Detalle();

        detalleOrden.setProducto(producto);
        detalleOrden.setCantidad(2);
//------------------------------------------------------------------------------------------
        Producto produ = new Producto();
        produ.setStock(100);
        produ.setNombre("Buzo");
        produ.setPrecioUnitario(100);

        Detalle detalleOrden1  = new Detalle();
        detalleOrden1.setProducto(producto);
        detalleOrden1.setCantidad(1);
        Set<Detalle> listDetalle = new HashSet<>();
        listDetalle.add(detalleOrden);
        listDetalle.add(detalleOrden1);
        Cliente cliente = new Cliente();
        cliente.setNombre("Alejandro");
        cliente.setDni(37803270);
        cliente.setApellido("Antelo");

        Orden orden = new Orden();
        orden.setCliente(cliente);
        orden.setDetalles(listDetalle);
        ordenService.insertar(orden);
    }
}