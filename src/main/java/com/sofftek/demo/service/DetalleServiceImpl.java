package com.sofftek.demo.service;

import com.sofftek.demo.dao.DetalleDao;
import com.sofftek.demo.entities.Detalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleServiceImpl implements DetalleService{
    @Autowired
    DetalleDao detalleDao;

    @Override
    @Transactional(readOnly = true)
    public Detalle buscarDetalleById(Integer id) {
        return detalleDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Detalle detalleOrden) {
        detalleDao.save(detalleOrden);
    }

    @Override
    @Transactional(readOnly = true)

    public List<Detalle> listarActivos() {

        return detalleDao.findByActivo();
    }

    @Override
    public Page<Detalle> listarActivos(Pageable pageable) {
        return detalleDao.findByActivo(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Detalle> listarTodos() {
        return detalleDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Detalle detalleOrdenAEliminar = detalleDao.findById(id).orElse(null);
        detalleDao.delete(detalleOrdenAEliminar);
    }

    @Override
    @Transactional
    public void modificar(Detalle detalleOrden) {
        detalleDao.save(detalleOrden);
    }
}
