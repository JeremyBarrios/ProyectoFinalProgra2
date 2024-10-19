import React from 'react';
import Articulo from './Articulo';

const ArticuloList = ({ articulos, agregarAlCarrito }) => {
    return (
        <div>
            <h2>Lista de Artículos</h2>
            {articulos.map((articulo) => (
                <Articulo
                    key={articulo.articuloId}
                    articulo={articulo}
                    agregarAlCarrito={agregarAlCarrito}
                />
            ))}
        </div>
    );
};

export default ArticuloList;
