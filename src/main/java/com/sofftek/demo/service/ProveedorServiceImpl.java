package com.sofftek.demo.service;


import com.sofftek.demo.dao.ProveedorDao;
import com.sofftek.demo.entities.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorDao proveedorDao;

    @Override
    @Transactional(readOnly = true)
    public Proveedor buscarProductoById(Integer id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Proveedor proveedor) {

        proveedorDao.save(proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> listarActivos() {

        List<Proveedor> proveedores =proveedorDao.findByActivo();

        return  proveedores;

    }

    @Override
    @Transactional
    public void eliminar(Integer id) {

        Proveedor proveedor = proveedorDao.findById(id).orElse(null);
        proveedorDao.delete(proveedor);
    }

    @Override
    @Transactional
    public void modificar(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }
}
