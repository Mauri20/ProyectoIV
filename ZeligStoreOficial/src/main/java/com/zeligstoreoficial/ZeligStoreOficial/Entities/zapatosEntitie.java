package com.zeligstoreoficial.ZeligStoreOficial.Entities;

import javax.persistence.*;

@Entity
@Table(name = "zapatos")
public class zapatosEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idZapato;
    @Column
    private Double tala;
    @Column
    private String color;
    @Column
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private categoriasEntitie idCategoria;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private marcasEntitie idMarca;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private estilosEntitie idEstilo;

    //----------Methods GET and SET


    public Integer getIdZapato() {
        return idZapato;
    }

    public void setIdZapato(Integer idZapato) {
        this.idZapato = idZapato;
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

    public categoriasEntitie getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(categoriasEntitie idCategoria) {
        this.idCategoria = idCategoria;
    }

    public marcasEntitie getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(marcasEntitie idMarca) {
        this.idMarca = idMarca;
    }

    public estilosEntitie getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(estilosEntitie idEstilo) {
        this.idEstilo = idEstilo;
    }
}
