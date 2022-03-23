package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table (name = "rol",schema="mapeo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_rol",columnNames = "nombre_rol")}
)

public class rol {
    @Id
    private long Id;
    @Column(name = "nombre_rol", length = 20, nullable = false)
    private String NombreRol;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String nombreRol) {
        NombreRol = nombreRol;
    }
}