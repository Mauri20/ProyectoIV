package com.zeligstoreoficial.ZeligStoreOficial.ResponseClass;

public class ZapatoResponse {
    String Modelo;
    double Talla;
    String Color;
    double Precio;
    byte[] Foto;
    int IdCategoria;
    int IdMarca;
    int IdEstilo;

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public double getTalla() {
        return Talla;
    }

    public void setTalla(double talla) {
        Talla = talla;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        IdCategoria = idCategoria;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int idMarca) {
        IdMarca = idMarca;
    }

    public int getIdEstilo() {
        return IdEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        IdEstilo = idEstilo;
    }


}
