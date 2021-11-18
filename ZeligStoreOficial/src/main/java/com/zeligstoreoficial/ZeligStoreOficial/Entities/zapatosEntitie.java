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
    private Double tala;
    @Column
    private String color;
    @Column
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private categoriasEntitie idcategoria;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private marcasEntitie idmarca;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private estilosEntitie idestilo;

    //----------Methods GET and SET

    public Integer getIdzapato() {
        return idzapato;
    }

    public void setIdzapato(Integer idzapato) {
        this.idzapato = idzapato;
    }

    public Double getTala() {
        return tala;
    }

    public void setTala(Double tala) {
        this.tala = tala;
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

    public categoriasEntitie getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(categoriasEntitie idcategoria) {
        this.idcategoria = idcategoria;
    }

    public marcasEntitie getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(marcasEntitie idmarca) {
        this.idmarca = idmarca;
    }

    public estilosEntitie getIdestilo() {
        return idestilo;
    }

    public void setIdestilo(estilosEntitie idestilo) {
        this.idestilo = idestilo;
    }
}
