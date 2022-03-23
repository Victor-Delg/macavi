package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipo_dni", schema="mapeo",uniqueConstraints = {
    @UniqueConstraint(name="uk_tipo_dni", columnNames="nombre_dni")
})
public class TipoDni {
    @Id
    private long id;
    @Column(name="nombre_dni", length=20 , nullable=false)
    private String NombreDni;

    @OneToMany(mappedBy = "IDTipoDni")
    private List<usuario> usuarioLists;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreDni() {
        return this.NombreDni;
    }

    public void setNombreDni(String NombreDni) {
        this.NombreDni = NombreDni;
    }
    

    
}
