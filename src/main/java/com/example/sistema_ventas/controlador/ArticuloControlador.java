package com.example.sistema_ventas.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_ventas.modelo.Articulo;
import com.example.sistema_ventas.servicio.ArticuloServicio;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloControlador {

    @Autowired
    private ArticuloServicio articuloServicio;

    // Reporte de existencia de artículos (por ID)
    @GetMapping("/reporte/{id}")
    public ResponseEntity<Articulo> obtenerArticuloPorId(@PathVariable String id) {
        Optional<Articulo> articuloOpt = articuloServicio.buscarArticuloPorId(id);
        return articuloOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
