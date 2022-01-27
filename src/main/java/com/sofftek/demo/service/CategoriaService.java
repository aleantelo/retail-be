package com.sofftek.demo.service;

import com.sofftek.demo.entities.Categoria;
import com.sofftek.demo.entities.Cliente;

import java.util.List;

public interface CategoriaService {

    public Categoria buscarCategoriaById(Integer id);

    public void insertar(Categoria categoria);

    public List<Categoria> listarActivos();

    public List<Categoria> listarTodos();

    public void eliminar(Integer id);

    public void modificar(Categoria categoria);
}
