// src/components/Pedido.js
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from '../service/AxiosConfig';

const Pedido = () => {
    const [carrito, setCarrito] = useState([]);
    const [pedidoTotal, setPedidoTotal] = useState(0);
    const [metodoPago, setMetodoPago] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        // Cargar los artículos del carrito para confirmar el pedido
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

    const confirmarPedido = () => {
        const pedidoData = {
            articulos: carrito,
            total: pedidoTotal,
            metodoPago: metodoPago
        };

        // Realizar la solicitud al backend para crear el pedido
        axios.post('/api/pedido', pedidoData)
            .then(response => {
                console.log("Pedido confirmado:", response.data);
                navigate('/confirmacion');  // Redirigir a una página de confirmación
            })
            .catch(error => console.error("Error al confirmar el pedido:", error));
    };

    return (
        <div>
            <h2>Confirmar Pedido</h2>
            <ul>
                {carrito.map((articulo, index) => (
                    <li key={index}>
                        {articulo.nombre} - {articulo.cantidad} x ${articulo.precio}
                    </li>
                ))}
            </ul>
            <h3>Total: ${pedidoTotal}</h3>

            <div>
                <label>Método de Pago:</label>
                <select value={metodoPago} onChange={(e) => setMetodoPago(e.target.value)}>
                    <option value="">Selecciona un método de pago</option>
                    <option value="tarjeta">Tarjeta de Crédito</option>
                    <option value="paypal">PayPal</option>
                    <option value="transferencia">Transferencia Bancaria</option>
                </select>
            </div>

            <button onClick={confirmarPedido} disabled={!metodoPago}>
                Confirmar Pedido
            </button>
        </div>
    );
};

export default Pedido;
