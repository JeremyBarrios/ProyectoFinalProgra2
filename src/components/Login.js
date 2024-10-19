import axios from 'axios';
import React, { useState } from 'react';

const Login = () => {
    const [credenciales, setCredenciales] = useState({
        email: '',
        password: '',
    });

    const manejarCambio = (e) => {
        const { name, value } = e.target;
        setCredenciales((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const manejarLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/login', credenciales);
            // Aquí manejar la respuesta, como guardar el token
            alert('Inicio de sesión exitoso');
        } catch (error) {
            console.error(error);
            alert('Error al iniciar sesión');
        }
    };

    return (
        <div>
            <h2>Iniciar Sesión</h2>
            <form onSubmit={manejarLogin}>
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={credenciales.email}
                    onChange={manejarCambio}
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Contraseña"
                    value={credenciales.password}
                    onChange={manejarCambio}
                />
                <button type="submit">Iniciar Sesión</button>
            </form>
        </div>
    );
};

export default Login;
