package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table (name = "rol",schema="mapeo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_rol",columnNames = "nombre_rol")}
)

public class rol {
    @Id
    private long id;
    @Column(name = "nombre_rol", length = 20, nullable = false)
    private String nombreRol;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}