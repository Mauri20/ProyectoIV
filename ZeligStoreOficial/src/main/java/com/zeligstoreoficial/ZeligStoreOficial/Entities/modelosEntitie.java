package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "modelos")
public class modelosEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idmodelo;
    @Column
    private String nombremod;
    @ManyToOne
    @JoinColumn(name = "idmarca")
    private marcasEntitie idmarca;

    public Integer getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Integer idmodelo) {
        this.idmodelo = idmodelo;
    }

    public String getNombremod() {
        return nombremod;
    }

    public void setNombremod(String nombremod) {
        this.nombremod = nombremod;
    }

    public marcasEntitie getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(marcasEntitie idmarca) {
        this.idmarca = idmarca;
    }
}
