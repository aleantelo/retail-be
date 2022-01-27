package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "promocion_producto")
@Setter
@Getter
public class PromocionProducto extends Activable{

    @ManyToOne(targetEntity = Producto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id",referencedColumnName = "id")
    private Producto producto;

    @ManyToOne(targetEntity = PromocionVigencia.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "promocion_vigencia_id",referencedColumnName = "id")
    private PromocionVigencia promocionVigencia;

    @Column(name = "descuento")
    private double descuento;
}
