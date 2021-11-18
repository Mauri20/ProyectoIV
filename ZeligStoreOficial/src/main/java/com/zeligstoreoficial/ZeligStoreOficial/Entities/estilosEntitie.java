package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "estilos")
public class estilosEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEstilo;
    @Column
    private String nombre;
    @Column
    private String modelo;

    //----------Methods GET and SET


    public Integer getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(Integer idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
