package com.example.sistema_ventas.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sistema_ventas.modelo.Transaccion;

public interface TransaccionRepositorio extends MongoRepository<Transaccion, String> {
    List<Transaccion> findByClienteId(String clienteId); // Ajusta según el nombre correcto
}
