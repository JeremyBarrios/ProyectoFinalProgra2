package com.example.sistema_ventas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.Articulo;

@Repository
public interface ArticuloRepositorio extends MongoRepository<Articulo, String> {
    // Métodos personalizados si es necesario
}
