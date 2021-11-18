package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class usuariosEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idUsuario;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String contrasena;

    //----------Methods GET and SET

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
