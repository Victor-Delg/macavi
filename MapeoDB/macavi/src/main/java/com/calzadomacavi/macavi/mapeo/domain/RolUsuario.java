package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table(name = "rol_usuario",schema = "mapeo")

public class RolUsuario {

    @Id
    private long Id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_rol",nullable = false, referencedColumnName = "Id",
            foreignKey = @ForeignKey(name = "fk_rol_usua"))

    private Rol rol;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario",nullable = false, referencedColumnName = "Id",
            foreignKey = @ForeignKey(name = "fk_usua_rol"))

    private Usuario usuario;

}
