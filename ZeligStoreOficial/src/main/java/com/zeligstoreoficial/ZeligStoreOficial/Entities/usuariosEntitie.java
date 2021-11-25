package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class usuariosEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idusuario;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String usuario;
    @Column
    private String contrasena;

    @Column
    private Integer tipousuario;
//----------Methods GET and SET


    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Integer tipousuario) {
        this.tipousuario = tipousuario;
    }
}
