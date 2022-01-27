package com.sofftek.demo.dao;

import com.sofftek.demo.entities.Orden;
import com.sofftek.demo.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenDao extends JpaRepository<Orden,Integer> {

    @Query("SELECT o FROM Orden o WHERE o.activo=true")
    List<Orden> findByActivo();

    @Query("SELECT o FROM Orden o WHERE o.activo=true")
    Page<Orden> findByActivo(Pageable pageable);
}
