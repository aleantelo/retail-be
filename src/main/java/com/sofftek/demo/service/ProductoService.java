package com.sofftek.demo.service;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

public interface ProductoService {

    public Producto buscarProductoById(Integer id);

    public void insertar(Producto producto);

    public List<Producto> listarActivos();

    public Page<Producto> listarActivos(Pageable pageable);

    public void eliminar(Integer id);

    public void modificar(Producto producto);
}
