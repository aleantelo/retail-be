package com.sofftek.demo.service;

import com.sofftek.demo.dao.ClienteDao;
import com.sofftek.demo.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    @Transactional
    public Cliente buscarClienteById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional ( readOnly = true)
    public List<Cliente> listarActivos() {
       return clienteDao.findByActivo();
    }

    @Override
    @Transactional ( readOnly = true)

    public List<Cliente> listarTodos() {
       return clienteDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Cliente cliente = clienteDao.findById(id).orElse(null);
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional
    public void modificar(Cliente cliente) {
        clienteDao.save(cliente);
    }
}