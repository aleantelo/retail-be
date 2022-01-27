package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rol")
@Setter
@Getter
public class Rol extends EntidadPersistente{

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(targetEntity = Permisos.class,cascade = CascadeType.ALL)
    @JoinTable(
            name="rol_tiene_permiso",
            joinColumns = {@JoinColumn(name = "rol_id")},
            inverseJoinColumns = {@JoinColumn(name = "permiso_id")}
    )
    private Set<Permisos> permisos;
}
