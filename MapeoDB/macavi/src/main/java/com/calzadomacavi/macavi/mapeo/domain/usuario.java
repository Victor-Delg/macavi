package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;


@Entity
@Table (name = "usuario",schema = "mapeo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_dni", columnNames = {"id_dni","numero_dni"}),
        @UniqueConstraint(name = "uk_usuario_login", columnNames = "login_usuario"),
        @UniqueConstraint(name = "uk_email", columnNames = "email")

})

public class usuario {
    @Id
    private long Id;
    @Column(name = "numero_dni", length = 50,nullable = false)
    private String NumeroDni;
    @Column(name = "nombre",length = 20,nullable = false)
    private String Nombre;
    @Column(name = "login_usuario",length = 80,nullable = false)
    private String LoginUsuario;
    @Column(name = "password",length = 30,nullable = false)
    private String Password;
    @Column(name = "email",length = 100,nullable = false)
    private String Email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_dni",nullable = false, referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_usu_dni"))

    private TipoDni dni;


}
