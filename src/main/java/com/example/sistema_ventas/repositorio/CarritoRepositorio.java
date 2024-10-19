package com.example.sistema_ventas.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.Carrito;

@Repository
public interface CarritoRepositorio extends MongoRepository<Carrito, String> {
    Optional<Carrito> findByIdCliente(String idCliente);
}
