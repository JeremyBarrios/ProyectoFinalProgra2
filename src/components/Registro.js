import axios from 'axios';
import React, { useState } from 'react';

const Registro = () => {
    const [usuario, setUsuario] = useState({
        nombre: '',
        email: '',
        password: '',
        perfil: 'CLIENTE', // CLIENTE o ADMINISTRADOR
    });

    const manejarCambio = (e) => {
        const { name, value } = e.target;
        setUsuario((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const manejarRegistro = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/usuarios', usuario);
            alert('Registro exitoso');
        } catch (error) {
            console.error(error);
            alert('Error en el registro');
        }
    };

    return (
        <div>
            <h2>Registro de Usuario</h2>
            <form onSubmit={manejarRegistro}>
                <input
                    type="text"
                    name="nombre"
                    placeholder="Nombre"
                    value={usuario.nombre}
                    onChange={manejarCambio}
                />
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={usuario.email}
                    onChange={manejarCambio}
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Contraseña"
                    value={usuario.password}
                    onChange={manejarCambio}
                />
                <select name="perfil" value={usuario.perfil} onChange={manejarCambio}>
                    <option value="CLIENTE">Cliente</option>
                    <option value="ADMINISTRADOR">Administrador</option>
                </select>
                <button type="submit">Registrarse</button>
            </form>
        </div>
    );
};

export default Registro;
