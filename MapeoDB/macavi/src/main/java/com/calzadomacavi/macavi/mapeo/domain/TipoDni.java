package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table(name="tipo_dni",uniqueConstraints = {
    @UniqueConstraint(name="uk_tipo_dni", columnNames="nombre_dni")
})
public class TipoDni {
    @Id
    private long id;
    @Column(name="nombre_dni", length=20 , nullable=false)
    private String NombreDni;

    

    
}
