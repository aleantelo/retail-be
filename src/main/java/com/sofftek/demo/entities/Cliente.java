package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Setter
@Getter
public class Cliente extends Activable{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "razon_social", unique = true)
    private String razon_social;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "tipo_cliente")
    @Enumerated(EnumType.STRING)
    private TipoDeCliente tipoDeCliente;

    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario",referencedColumnName = "id")
    private Usuario usuario;

    public Cliente(){
        this.setActivo(true);
    }

}