package com.calzadomacavi.macavi.mapeo.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="producto", schema="mapeo")
public class Producto {
    @Id
    private long id;
    @Column(name="descripcion_producto", length=100, nullable=false)
    private String descripcion_producto;
    @Column(name="marca", length=20, nullable=false)
    private String marca;
    @Column(name="genero", length=20, nullable=false)
    private String genero;
    @Column(name="talla", length=4, nullable=false)
    private int talla;
    @Column(name="estilo", length=20, nullable=false)
    private String estilo;
    @Column(name="cantidad_producto", length=4, nullable=false)
    private int cantidadProducto;
    @Column(name="porcentaje_iva", length=4)
    private float porcentajeIva;

    @ManyToMany(mappedBy = "productos")
    private List<Factura> factura ;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getDescripcion_producto() {
        return this.descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTalla() {
        return this.talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getEstilo() {
        return this.estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getCantidad_producto() {
        return this.cantidadProducto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidadProducto = cantidad_producto;
    }

    public float getPorcentaje_iva() {
        return this.porcentajeIva;
    }

    public void setPorcentaje_iva(float porcentaje_iva) {
        this.porcentajeIva = porcentaje_iva;
    }

    
}
