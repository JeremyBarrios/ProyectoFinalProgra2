package com.example.sistema_ventas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sistema_ventas.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
    // Define tus métodos de consulta aquí
    Usuario findByUsername(String username);
}
