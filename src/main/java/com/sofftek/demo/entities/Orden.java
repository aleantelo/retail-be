package com.sofftek.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orden")
@Setter
@Getter
public class Orden extends Activable{

    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(targetEntity = Empleado.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id",referencedColumnName = "id")
    private Empleado vendedor;

    @Column(name  = "fecha_generada")
    private LocalDate fechaGenerada;

    @Column(name = "fecha_entrega")
    private LocalDate fechaDeEntrega;

    @ManyToMany(targetEntity = Detalle.class,cascade = CascadeType.ALL)
    @JoinTable(
            name="detalle_orden",
            joinColumns = {@JoinColumn(name = "orden_id")},
            inverseJoinColumns = {@JoinColumn(name = "detalle_id")}
    )
    private Set<Detalle> detalles;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Orden (){
        detalles = new HashSet<>();
        this.setActivo(true);
        this.setEstado(Estado.ABIERTO);
        this.setFechaGenerada(LocalDate.now());
    }

    public void agregarDetalles(Set<Detalle> listaDetalles){
        for (Detalle detalle:listaDetalles){
            detalles.add(detalle);
        }
    }
}
