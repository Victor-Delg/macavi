package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity
@Table(name="factura", schema="mapeo")

public class Factura {
    @Id
    private String id;
    @Column(name="fecha_fact", length=4, nullable=false)
    private Data fecha_fact;
    @Column(name="fecha_venc", length=4 )
    private Data fecha_venc;
    @Column(name="total_factura", length=4, nullable=false)
    private int total_factura;
    @Column(name="descripcion", length=500, nullable=false)
    private String descripcion;
    @Column(name="tipo_pago", length=10, nullable=false)
    private String tipo_pago;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_fact_clie")
    )
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_fact_usuario")
    )
    private usuario usuario;


}
