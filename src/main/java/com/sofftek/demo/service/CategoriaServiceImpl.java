package com.sofftek.demo.service;

import com.sofftek.demo.dao.CategoriaDao;
import com.sofftek.demo.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional
    public Categoria buscarCategoriaById(Integer id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional ( readOnly = true)
    public List<Categoria> listarActivos() {
        return categoriaDao.findByActivo();
    }

    @Override
    @Transactional ( readOnly = true)
    public List<Categoria> listarTodos() {
        return categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Categoria categoria = categoriaDao.findById(id).orElse(null);
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional
    public void modificar(Categoria categoria) {
        categoriaDao.save(categoria);
    }
}
