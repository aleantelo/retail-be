package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permisos")
@Setter
@Getter
public class Permisos extends EntidadPersistente{

    @Column(name = "nombre")
    private String nombre;
}
