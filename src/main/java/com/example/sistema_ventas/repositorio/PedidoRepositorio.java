package com.example.sistema_ventas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.Pedido;

@Repository
public interface PedidoRepositorio extends MongoRepository<Pedido, String> {
    // Métodos personalizados si es necesario
}
