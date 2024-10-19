package com.example.sistema_ventas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_ventas.modelo.Transaccion;
import com.example.sistema_ventas.repositorio.TransaccionRepositorio;

@Service
public class TransaccionServicio {

    @Autowired
    private TransaccionRepositorio transaccionRepositorio;

    public List<Transaccion> buscarTransaccionesPorIdCliente(String clienteId) {
        // Aquí se buscarán las transacciones del cliente a partir del ID del cliente.
        return transaccionRepositorio.findByClienteId(clienteId);
    }
}
