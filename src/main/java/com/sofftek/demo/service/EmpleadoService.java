package com.sofftek.demo.service;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;

import javax.persistence.Query;
import java.util.List;

public interface EmpleadoService {

    public Empleado buscarEmpleadoteById(Integer id);

    public void insertar(Empleado empleado);

    public List<Empleado> listarActivos();

    public List<Empleado> listarTodos();

    public void eliminar(Integer id);

    public void modificar(Empleado empleado);

}
