package com.sofftek.demo.service;

import com.sofftek.demo.entities.Producto;
import com.sofftek.demo.entities.Proveedor;

import java.util.List;

public interface ProveedorService {

    public Proveedor buscarProductoById(Integer id);

    public void insertar(Proveedor proveedor);

    public List<Proveedor> listarActivos();

    public void eliminar(Integer id);

    public void modificar(Proveedor proveedor);
}
