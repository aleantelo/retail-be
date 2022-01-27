package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class Activable extends EntidadPersistente {

    @Column(name = "activo")
    private Boolean activo;
}
