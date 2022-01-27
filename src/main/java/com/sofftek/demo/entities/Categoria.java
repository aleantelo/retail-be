package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="categoria")
@Setter
@Getter
public class Categoria extends Activable{

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(targetEntity = Proveedor.class,cascade = CascadeType.MERGE)
    @JoinTable(
            name="proveedor_categoria",
            joinColumns = {@JoinColumn(name = "categoria_id")},
            inverseJoinColumns = {@JoinColumn(name = "proveedor_id")}
    )
    private Set<Proveedor> proveedores;

    public Categoria(){
        this.setActivo(true);
        proveedores = new HashSet<>();
    }

    public void agregarProveedores(Proveedor ... proveedores){
        Collections.addAll(this.proveedores,proveedores);
    }
}