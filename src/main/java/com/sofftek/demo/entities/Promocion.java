package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promocion")
@Setter
@Getter
public class Promocion extends Activable{

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="descripcion")
    private String descripcion;
}
