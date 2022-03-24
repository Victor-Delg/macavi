package com.calzadomacavi.macavi.mapeo.domain;


import javax.persistence.*;

@Entity
@Table(name="producto_factura", schema = "mapeo")
public class ProductoFactura {
    @Id
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto",nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_fac_prod"))
    private Producto producto;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_factura",nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_fac_fapr"))
    private Factura factura;

}
