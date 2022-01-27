package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalle")
@Setter
@Getter
public class Detalle extends Activable {

    @ManyToOne(targetEntity = Producto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    public Detalle(){
        this.setActivo(true);
    }
}
