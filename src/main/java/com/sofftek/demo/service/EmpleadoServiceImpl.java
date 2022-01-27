package com.sofftek.demo.service;

import com.sofftek.demo.dao.EmpleadoDao;
import com.sofftek.demo.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public Empleado buscarEmpleadoteById(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insertar(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)

    public List<Empleado> listarActivos() {
        return empleadoDao.findByActivo();
    }

    @Override
    @Transactional(readOnly = true)

    public List<Empleado> listarTodos() {
        return empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Empleado empleado = empleadoDao.findById(id).orElse(null);
        empleadoDao.delete(empleado);
    }

    @Override
    @Transactional
    public void modificar(Empleado empleado) {
        empleadoDao.save(empleado);
    }
}
