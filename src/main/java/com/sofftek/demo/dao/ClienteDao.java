package com.sofftek.demo.dao;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ClienteDao extends JpaRepository<Cliente,Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.activo=true")
    List<Cliente> findByActivo();
}
