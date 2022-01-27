package com.sofftek.demo.service;

import com.sofftek.demo.dao.UsuarioDao;
import com.sofftek.demo.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarActivos() {

        return usuarioDao.findByActivo();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Usuario usuario = usuarioDao.findById(id).orElse(null);
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional
    public void modificar(Usuario usuario) {
        usuarioDao.save(usuario);
    }
}
