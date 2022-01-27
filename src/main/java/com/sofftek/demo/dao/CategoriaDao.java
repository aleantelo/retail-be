package com.sofftek.demo.dao;


import com.sofftek.demo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria,Integer> {


    @Query("SELECT c FROM Categoria c WHERE c.activo=true")
    List<Categoria> findByActivo();
}
