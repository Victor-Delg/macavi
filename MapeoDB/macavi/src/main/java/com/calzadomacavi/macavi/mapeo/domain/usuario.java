package com.calzadomacavi.macavi.mapeo.domain;

import javax.persistence.*;


@Entity
@Table (name = "usuario",schema = "mapeo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_dni", columnNames = {"id_tipo_dni","numero_dni"}),
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
    @JoinColumn(name = "id_tipo_dni",nullable = false, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_usu_dni"))


    public void setId(long id) {
        Id = id;
    }

    public String getNumeroDni() {
        return NumeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        NumeroDni = numeroDni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getLoginUsuario() {
        return LoginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        LoginUsuario = loginUsuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public TipoDni getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(TipoDni tipoDni) {
        this.tipoDni = tipoDni;
    }
}
