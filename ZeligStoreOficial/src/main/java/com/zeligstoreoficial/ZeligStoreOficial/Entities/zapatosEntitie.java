package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "zapatos")
public class zapatosEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idzapato;
    @Column
    private Double talla;
    @Column
    private String color;
    @Column
    private Double precio;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private categoriasEntitie idcategoria;

    @ManyToOne
    @JoinColumn(name = "idmodelo")
    private modelosEntitie idmodelo;

    @ManyToOne
    @JoinColumn(name = "idestilo")
    private estilosEntitie idestilo;

    //----------Methods GET and SET

    public Integer getIdzapato() {
        return idzapato;
    }

    public void setIdzapato(Integer idzapato) {
        this.idzapato = idzapato;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public categoriasEntitie getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(categoriasEntitie idcategoria) {
        this.idcategoria = idcategoria;
    }

    public modelosEntitie getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(modelosEntitie idmodelo) {
        this.idmodelo = idmodelo;
    }

    public estilosEntitie getIdestilo() {
        return idestilo;
    }

    public void setIdestilo(estilosEntitie idestilo) {
        this.idestilo = idestilo;
    }
}
