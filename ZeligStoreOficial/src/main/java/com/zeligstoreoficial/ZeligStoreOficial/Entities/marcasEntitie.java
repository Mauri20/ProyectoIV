package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "marcas")
public class marcasEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idmarca;
    @Column
    private String nombremar;

    //----------Methods GET and SET

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public String getNombremar() {
        return nombremar;
    }

    public void setNombremar(String nombremar) {
        this.nombremar = nombremar;
    }
}
