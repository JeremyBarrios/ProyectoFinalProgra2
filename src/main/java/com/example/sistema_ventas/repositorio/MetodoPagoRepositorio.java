package com.example.sistema_ventas.repositorio;

import com.example.sistema_ventas.modelo.MetodoPago;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepositorio extends MongoRepository<MetodoPago, String> {
    // Métodos personalizados si es necesario
}
