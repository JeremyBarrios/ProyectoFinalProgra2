package com.example.sistema_ventas.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<ArticuloCantidad> articulos = new ArrayList<>();

    public List<ArticuloCantidad> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<ArticuloCantidad> articulos) {
        this.articulos = articulos;
    }
}
