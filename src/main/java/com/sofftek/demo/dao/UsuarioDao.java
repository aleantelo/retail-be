package com.sofftek.demo.dao;

import com.sofftek.demo.entities.Cliente;
import com.sofftek.demo.entities.Empleado;
import com.sofftek.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.activo=true")
    List<Usuario> findByActivo();

}
