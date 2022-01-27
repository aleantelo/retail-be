package com.sofftek.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
@Setter
@Getter
public class Producto extends Activable{

    @NotBlank(message = "Campo vacio")
    @Column(name = "nombre")
    private String nombre;

    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Positive(message = "El stock debe ser mayor a 0")
    @Column(name = "unidades_stock")
    private Integer stock;

    @ManyToOne(targetEntity = Proveedor.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "proveedor_id",referencedColumnName = "id")
    private Proveedor proveedor;

    @ManyToOne(targetEntity = Categoria.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoria_id",referencedColumnName = "id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private Set<PromocionProducto> promocionProductos;

    public Producto(){
        this.setActivo(true);
        promocionProductos=new HashSet<>();
    }

}
