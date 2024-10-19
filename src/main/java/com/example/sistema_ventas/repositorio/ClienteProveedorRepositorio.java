package com.example.sistema_ventas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.ClienteProveedor;

@Repository
public interface ClienteProveedorRepositorio extends MongoRepository<ClienteProveedor, String> {
    // Métodos personalizados si es necesario
}
