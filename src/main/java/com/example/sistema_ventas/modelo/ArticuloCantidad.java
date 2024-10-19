package com.example.sistema_ventas.modelo;

public class ArticuloCantidad {

    private Articulo articulo;
    private int cantidad;

    // Constructor, getters y setters
    public ArticuloCantidad(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
