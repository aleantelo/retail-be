package com.sofftek.demo.dao;


import com.sofftek.demo.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoDao extends JpaRepository<Producto,Integer> {

    @Query("SELECT p FROM Producto p WHERE p.activo=true")
    List<Producto> findByActivo();

    @Query("SELECT p FROM Producto p WHERE p.activo=true")
    Page<Producto> findByActivo(Pageable pageable);
}