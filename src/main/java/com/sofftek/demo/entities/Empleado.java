package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
@Setter
@Getter
public class Empleado extends Activable{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public Empleado(){
        this.setActivo(true);
    }

}
