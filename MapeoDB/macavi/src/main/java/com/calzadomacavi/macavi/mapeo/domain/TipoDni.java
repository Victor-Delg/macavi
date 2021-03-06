package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipo_dni", schema="mapeo",uniqueConstraints = {
    @UniqueConstraint(name="uk_tipo_dni", columnNames="nombre_dni")
})
public class TipoDni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="nombre_dni", length=20 , nullable=false)
    private String NombreDni;

    @OneToMany(mappedBy = "tipoDni")
    private List<Usuario> usuarioList;


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
