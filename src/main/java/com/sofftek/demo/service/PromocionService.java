package com.sofftek.demo.service;

import com.sofftek.demo.entities.Promocion;
import com.sofftek.demo.entities.Usuario;

import java.util.List;

public interface PromocionService {

    public Promocion buscarPromocionById(Integer id);

    public void insertar(Promocion promocion);

    public List<Promocion> listarActivos();

    public void eliminar(Integer id);

    public void modificar(Promocion promocion);
}
