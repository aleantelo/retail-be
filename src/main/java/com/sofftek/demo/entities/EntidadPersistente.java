package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class EntidadPersistente {
    @Id
    @GeneratedValue //Es una clave subrogada
    @Column
    private Integer id;
}
