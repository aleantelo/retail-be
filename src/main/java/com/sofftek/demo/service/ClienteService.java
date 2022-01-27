package com.sofftek.demo.service;

import com.sofftek.demo.entities.Cliente;

import java.util.List;

public interface ClienteService {


    public Cliente buscarClienteById(Integer id);

    public void insertar(Cliente cliente);

    public List<Cliente> listarActivos();

    public List<Cliente> listarTodos();

    public void eliminar(Integer id);

    public void modificar(Cliente cliente);

}
