package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Activable {

    @Column(name = "nombre_usuario")
    private String nombreDeUsuario;

    @Column(name = "contraseña")
    private String contraseña;

    @ManyToMany(targetEntity = Rol.class,cascade = CascadeType.ALL)
    @JoinTable(
            name="usuario_tiene_rol",
            joinColumns = {@JoinColumn(name = "usuario_id")},
            inverseJoinColumns = {@JoinColumn(name = "rol_id")}
    )
    private Set<Rol> roles;
}
