package com.sofftek.demo.service;


import com.sofftek.demo.entities.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleService {

    public Detalle buscarDetalleById(Integer id);

    public void insertar(Detalle detalleOrden);

    public List<Detalle> listarActivos();

    public Page<Detalle> listarActivos(Pageable pageable);

    public List<Detalle> listarTodos();

    public void eliminar(Integer id);

    public void modificar(Detalle detalleOrden);
}
