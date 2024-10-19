// src/App.js
import React from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import ArticuloList from './components/ArticuloList';
import Carrito from './components/Carrito';
import Login from './components/Login';
import Pedido from './components/Pedido';
import Registro from './components/Registro';

function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/articulos" element={<ArticuloList />} />
                    <Route path="/carrito" element={<Carrito />} />
                    <Route path="/pedido" element={<Pedido />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/registro" element={<Registro />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
