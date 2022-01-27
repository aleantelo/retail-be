package com.sofftek.demo.service;

import com.sofftek.demo.dao.PromocionDao;
import com.sofftek.demo.entities.Promocion;
import com.sofftek.demo.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromocionServiceImpl implements PromocionService{

    @Autowired
    private PromocionDao promocionDao;


    @Override
    @Transactional(readOnly = true)
    public Promocion buscarPromocionById(Integer id) {
        return promocionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Promocion promocion) {
        promocionDao.save(promocion);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Promocion> listarActivos() {
        return promocionDao.findByActivo();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Promocion promocionAEliminar = promocionDao.findById(id).orElse(null);
        promocionDao.delete(promocionAEliminar);
    }

    @Override
    @Transactional
    public void modificar(Promocion promocion) {
        promocionDao.save(promocion);
    }
}
