package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;

@Entity
@Table(name="locate", schema="mapeo",uniqueConstraints={
    @UniqueConstraint(name="uk_locate", columnNames="departamento,pais,ciudad")
})
public class Locate {

    @Id
    private long id;
    @Column(name="pais", length=50,nullable=false)
    private String pais;
    @Column(name="departamento", length=50, nullable=false)
    private String departamento;
    @Column(name="ciudad", length=50, nullable=false)
    private String ciudad;
    
}
