package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "promocion_vigencia")
@Setter
@Getter
public class PromocionVigencia extends Activable{


    @ManyToOne(targetEntity = Promocion.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "promocion_id",referencedColumnName = "id")
    private Promocion promocion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicion;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;


}
