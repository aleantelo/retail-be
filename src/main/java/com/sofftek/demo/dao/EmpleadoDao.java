package com.sofftek.demo.dao;


import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface EmpleadoDao extends JpaRepository<Empleado,Integer> {

    @Query("SELECT e FROM Empleado e WHERE e.activo=true")
    List<Empleado> findByActivo();
}
