package com.sofftek.demo.service;

import com.sofftek.demo.dao.ProductoDao;
import com.sofftek.demo.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public Producto buscarProductoById(Integer id) {

        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Producto producto) {

        productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarActivos() {
        return productoDao.findByActivo();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> listarActivos(Pageable pageable) {
        return productoDao.findByActivo(pageable);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {

        Producto producto = productoDao.findById(id).orElse(null);

        productoDao.delete(producto);
    }

    @Override
    @Transactional
    public void modificar(Producto producto) {
        productoDao.save(producto);
    }
}
