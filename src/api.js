import axios from 'axios';

// Cambia la URL base según tu configuración de backend
const api = axios.create({
    baseURL: 'http://localhost:8080/api', // Cambia a la URL de tu backend
    headers: {
        'Content-Type': 'application/json',
    },
});

export const agregarPedido = (pedido) => api.post('/pedidos', pedido);

export default api;
