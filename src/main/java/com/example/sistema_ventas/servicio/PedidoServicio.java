package com.example.sistema_ventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_ventas.dto.PedidoDTO;
import com.example.sistema_ventas.modelo.Pedido;
import com.example.sistema_ventas.repositorio.PedidoRepositorio;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private CarritoServicio carritoServicio;

    public Pedido crearPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setArticulos(pedidoDTO.getArticulos());
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setMetodoPago(pedidoDTO.getMetodoPago());
        
        // Limpiar el carrito después de confirmar el pedido
        carritoServicio.limpiarCarrito();
        
        return pedidoRepositorio.save(pedido);
    }
}
