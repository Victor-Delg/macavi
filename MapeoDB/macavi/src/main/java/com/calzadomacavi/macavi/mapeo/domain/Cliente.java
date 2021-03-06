package com.calzadomacavi.macavi.mapeo.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente", schema="mapeo", uniqueConstraints={
    @UniqueConstraint(name="uk_usuario", columnNames="id_usuario")
})
public class Cliente{
    @Id
    private long id;
    @Column(name="direcion", length=60, nullable=false)
    private String direcion;
    @Column(name="telefono", length=4 , nullable=false)
    private int telefono;


    @ManyToOne(optional=false)
    @JoinColumn(name="id_locate",nullable=false,referencedColumnName="id",foreignKey = @ForeignKey(name="fk_clie_loca"))
    private Locate locate;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable=false, referencedColumnName="id", foreignKey= @ForeignKey(name="fk_usa_clie"))

    private Usuario Usuario;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturaList;
    
}
