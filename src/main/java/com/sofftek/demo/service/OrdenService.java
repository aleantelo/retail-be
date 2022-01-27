package com.sofftek.demo.service;

import com.sofftek.demo.entities.Orden;
import com.sofftek.demo.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrdenService {

    public Orden buscarProductoById(Integer id);

    public void insertar(Orden orden);

    public List<Orden> listarActivos();

    public Page<Orden> listarActivos(Pageable pageable);

    public void eliminar(Integer id);

    public void modificar(Orden orden);

}
