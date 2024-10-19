package com.example.sistema_ventas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_ventas.modelo.Transaccion;
import com.example.sistema_ventas.servicio.TransaccionServicio;

@RestController
@RequestMapping("/transacciones")
public class TransaccionControlador {

    @Autowired
    private TransaccionServicio transaccionServicio;

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Transaccion>> buscarTransaccionesPorIdCliente(@PathVariable String clienteId) {
        List<Transaccion> transacciones = transaccionServicio.buscarTransaccionesPorIdCliente(clienteId);
        return ResponseEntity.ok(transacciones);
    }
}
