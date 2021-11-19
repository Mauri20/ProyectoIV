package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "estilos")
public class estilosEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idestilo;
    @Column
    private String nombreest;

    //----------Methods GET and SET

    public Integer getIdestilo() {
        return idestilo;
    }

    public void setIdestilo(Integer idestilo) {
        this.idestilo = idestilo;
    }

    public String getNombreest() {
        return nombreest;
    }

    public void setNombreest(String nombreest) {
        this.nombreest = nombreest;
    }
}
