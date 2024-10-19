package com.example.sistema_ventas.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_ventas.modelo.Articulo;
import com.example.sistema_ventas.repositorio.ArticuloRepositorio;

@Service
public class ArticuloServicio {

    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    // Método para obtener un artículo por ID (reporte de existencia de artículos)
    public Optional<Articulo> buscarArticuloPorId(String id) {
        return articuloRepositorio.findById(id);
    }
}
