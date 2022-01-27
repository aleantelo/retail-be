package com.sofftek.demo.dao;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ProveedorDao extends JpaRepository<Proveedor,Integer> {

    @Query("SELECT p FROM Proveedor p WHERE p.activo=true")
    List<Proveedor> findByActivo();
}
