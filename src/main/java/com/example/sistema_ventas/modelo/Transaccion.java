package com.example.sistema_ventas.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transaccion {
    @Id
    private String id;
    private String clienteId; // Asegúrate de que este campo esté aquí
    private double monto;
    // otros campos, getters y setters
}
