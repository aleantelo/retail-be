package com.sofftek.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
@Setter
@Getter
public class Proveedor extends Activable {

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "direccion")
    private String direccion;

    public Proveedor(){
        this.setActivo(true);
    }
}