// src/components/Carrito.js
import React, { useState, useEffect } from 'react';
import axios from '../service/AxiosConfig';
import { useNavigate } from 'react-router-dom';

const Carrito = () => {
    const [carrito, setCarrito] = useState([]);
    const [pedidoTotal, setPedidoTotal] = useState(0);
    const navigate = useNavigate();

    useEffect(() => {
        // Cargar los artículos del carrito desde el backend
        axios.get('/api/carrito')
            .then(response => {
                setCarrito(response.data.articulos);
                calcularTotal(response.data.articulos);
            })
            .catch(error => console.error("Error al obtener el carrito:", error));
    }, []);

    const calcularTotal = (articulos) => {
        const total = articulos.reduce((sum, articulo) => sum + (articulo.cantidad * articulo.precio), 0);
        setPedidoTotal(total);
    };

    const eliminarArticulo = (id) => {
        axios.delete(`/api/carrito/${id}`)
            .then(() => {
                const nuevoCarrito = carrito.filter(articulo => articulo.id !== id);
                setCarrito(nuevoCarrito);
                calcularTotal(nuevoCarrito);
            })
            .catch(error => console.error("Error al eliminar el artículo:", error));
    };

    const actualizarCantidad = (id, nuevaCantidad) => {
        axios.put(`/api/carrito/${id}`, { cantidad: nuevaCantidad })
            .then(() => {
                const nuevoCarrito = carrito.map(articulo => 
                    articulo.id === id ? { ...articulo, cantidad: nuevaCantidad } : articulo
                );
                setCarrito(nuevoCarrito);
                calcularTotal(nuevoCarrito);
            })
            .catch(error => console.error("Error al actualizar la cantidad:", error));
    };

    const continuarPedido = () => {
        navigate('/pedido');  // Redirige a la página de pedido para confirmar
    };

    return (
        <div>
            <h2>Carrito de Compras</h2>
            <ul>
                {carrito.map((articulo, index) => (
                    <li key={index}>
                        {articulo.nombre} - 
                        <input 
                            type="number" 
                            value={articulo.cantidad} 
                            onChange={(e) => actualizarCantidad(articulo.id, e.target.value)} 
                        /> 
                        x ${articulo.precio}
                        <button onClick={() => eliminarArticulo(articulo.id)}>Eliminar</button>
                    </li>
                ))}
            </ul>
            <h3>Total: ${pedidoTotal}</h3>
            <button onClick={continuarPedido}>Proceder a Pedido</button>
        </div>
    );
};

export default Carrito;
