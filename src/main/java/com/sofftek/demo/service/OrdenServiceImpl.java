package com.sofftek.demo.service;


import com.sofftek.demo.dao.OrdenDao;
import com.sofftek.demo.entities.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {



    @Autowired
    OrdenDao ordenDao;

    @Override
    public Orden buscarProductoById(Integer id) {
        return ordenDao.findById(id).orElse(null);
    }

    @Override
    public void insertar(Orden orden) {

        ordenDao.save(orden);
    }

    @Override
    public List<Orden> listarActivos() {
        return ordenDao.findByActivo();
    }

    @Override
    public Page<Orden> listarActivos(Pageable pageable) {
        return ordenDao.findByActivo(pageable);
    }

    @Override
    public void eliminar(Integer id) {
        Orden ordenAEliminar = ordenDao.findById(id).orElse(null);
        ordenDao.delete(ordenAEliminar);
    }

    @Override
    public void modificar(Orden orden) {
        ordenDao.save(orden);
    }
}
