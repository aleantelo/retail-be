package com.sofftek.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "user")
public class Usuario extends Activable {

    @Column(name = "nombre_usuario")
    private String nombreDeUsuario;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "tipo")
    private String tipoDeUsuario;

    public Usuario (){
        this.setActivo(true);
    }
}
