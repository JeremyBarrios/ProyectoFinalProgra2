package com.example.sistema_ventas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.Empresa;

@Repository
public interface EmpresaRepositorio extends MongoRepository<Empresa, String> {
    // Métodos personalizados si es necesario
}
