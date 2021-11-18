package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "marcas")
public class marcasEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idMarca;
    @Column
    private String nombre;

    //----------Methods GET and SET


    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
