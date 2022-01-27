package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class OrdenSave {

    private Set<Detalle> detalles;

    public OrdenSave () {
        detalles=new HashSet<>();
    }

}
