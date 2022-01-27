package com.sofftek.demo.dao;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface PromocionDao extends JpaRepository<Promocion,Integer> {

    @Query("SELECT p FROM Promocion p WHERE p.activo=true")
    List<Promocion> findByActivo();

}
