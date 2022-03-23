package com.calzadomacavi.macavi.mapeo.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="locate", schema="mapeo",uniqueConstraints = {
    @UniqueConstraint(name="uk_locate",
    columnNames={"departamento","pais","ciudad"})
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

    @OneToMany(mappedBy="locate")
    private List<Cliente> clienteList;



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    
}
