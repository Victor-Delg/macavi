package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table(name = "rol_usuario",schema = "mapeo")

public class RolUsuario {

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_rol",nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_rol_usua"))

    private RolUsuario rolUsuario;

}
