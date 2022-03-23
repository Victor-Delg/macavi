package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table(name="cliente", schema="mapeo")
public class Cliente {
    @Id
    private long id;
    @Column(name="direcion", length=60, nullable=false)
    private String direcion;
    @Column(name="telefono", length=4 , nullable=false)
    private int telefono;
    
}
