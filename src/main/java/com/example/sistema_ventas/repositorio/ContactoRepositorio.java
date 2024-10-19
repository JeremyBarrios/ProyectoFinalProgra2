package com.example.sistema_ventas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.Contacto;

@Repository
public interface ContactoRepositorio extends MongoRepository<Contacto, String> {
    // Métodos personalizados si es necesario
}
