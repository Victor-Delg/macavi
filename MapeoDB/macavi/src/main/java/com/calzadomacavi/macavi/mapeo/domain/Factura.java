package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="factura", schema="mapeo")

public class Factura {
    @Id
    private long id;
    @Column(name="fecha_fact", length=4, nullable=false)
    private LocalDateTime fechaFact;
    @Column(name="fecha_venc", length=4 )
    private LocalDateTime fechaVenc;
    @Column(name="total_factura", length=4, nullable=false)
    private int totalFactura;
    @Column(name="descripcion", length=500, nullable=false)
    private String descripcion;
    @Column(name="tipo_pago", length=10, nullable=false)
    private String tipoPago;

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






    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFecha_fact() {
        return this.fechaFact;
    }


    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public long getId() {
        return id;
    }

    public LocalDateTime getFechaFact() {
        return fechaFact;
    }

    public void setFechaFact(LocalDateTime fechaFact) {
        this.fechaFact = fechaFact;
    }

    public LocalDateTime getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(LocalDateTime fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }


    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }


}
