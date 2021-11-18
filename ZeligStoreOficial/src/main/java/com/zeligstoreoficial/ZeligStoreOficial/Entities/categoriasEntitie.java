package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class categoriasEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idCategoria;
    @Column
    private String nombre;

    //----------Methods GET and SET


    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
