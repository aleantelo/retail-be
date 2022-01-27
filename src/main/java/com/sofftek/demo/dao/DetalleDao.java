package com.sofftek.demo.dao;

import com.sofftek.demo.entities.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleDao extends JpaRepository<Detalle,Integer> {

    @Query("SELECT d FROM Detalle d WHERE d.activo=true")
    List<Detalle> findByActivo();


    @Query("SELECT d FROM Detalle d WHERE d.activo=true")
    Page<Detalle> findByActivo(Pageable pageable);
}

