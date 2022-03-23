package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table(name = "rol_usuario",schema = "mapeo")

public class RolUsuario {

    @Id
    private long Id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_rol",nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_rol_usua"))


    private RolUsuario rolUsuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario",nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_usua-rol"))

    private RolUsuario usuario;


}
