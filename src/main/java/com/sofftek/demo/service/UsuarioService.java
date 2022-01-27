package com.sofftek.demo.service;

import com.sofftek.demo.entities.Producto;
import com.sofftek.demo.entities.Usuario;

import java.util.List;

public interface UsuarioService {


    public Usuario buscarUsuarioById(Integer id);

    public void insertar(Usuario usuario);

    public List<Usuario> listarActivos();

    public void eliminar(Integer id);

    public void modificar(Usuario usuario);

}
