package com.example.sistema_ventas.servicio;

import org.springframework.stereotype.Service;

import com.example.sistema_ventas.modelo.Carrito;

@Service
public class CarritoServicio {

    private Carrito carrito = new Carrito();

    public Carrito obtenerCarrito() {
        return carrito;
    }

    public void eliminarArticulo(String articuloId) {
        carrito.getArticulos().removeIf(articulo -> articulo.getArticulo().getId().equals(articuloId));
    }

    public void vaciarCarrito() {
        carrito.getArticulos().clear();
    }

    // Método para limpiar el carrito
    public void limpiarCarrito() {
        carrito.getArticulos().clear(); // Limpia todos los artículos del carrito
    }
}
