package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="factura", schema="mapeo")

public class Factura {
    @Id
    private String id;
    @Column(name="fecha_fact", length=4, nullable=false)
    private LocalDateTime fecha_fact;
    @Column(name="fecha_venc", length=4 )
    private LocalDateTime fecha_venc;
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

    //manytomany producto and factura
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinTable(name = "ingredientes", 
               joinColumns = { @JoinColumn( name="fk_factura") },
               inverseJoinColumns = { @JoinColumn(name = "fk_producto") })    
    Set<Producto> producto;

    @ManyToMany(targetEntity = Producto.class,
                cascade = CascadeType.ALL )
    private Set<Producto> producto2;







    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha_fact() {
        return this.fecha_fact;
    }

    public void setFecha_fact(LocalDateTime fecha_fact) {
        this.fecha_fact = fecha_fact;
    }

    public LocalDateTime getFecha_venc() {
        return this.fecha_venc;
    }

    public void setFecha_venc(LocalDateTime fecha_venc) {
        this.fecha_venc = fecha_venc;
    }

    public int getTotal_factura() {
        return this.total_factura;
    }

    public void setTotal_factura(int total_factura) {
        this.total_factura = total_factura;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_pago() {
        return this.tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }


}
