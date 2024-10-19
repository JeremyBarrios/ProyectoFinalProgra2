import axios from './AxiosConfig';

// Función para obtener el carrito actual
export const obtenerCarrito = async () => {
  try {
    const response = await axios.get('/carrito');
    return response.data;
  } catch (error) {
    console.error('Error al obtener el carrito:', error);
    return null;
  }
};

// Función para agregar un artículo al carrito
export const agregarArticulo = async (articuloCantidad) => {
  try {
    const response = await axios.post('/carrito/agregar', articuloCantidad);
    return response.data;
  } catch (error) {
    console.error('Error al agregar el artículo al carrito:', error);
    return null;
  }
};

// Función para eliminar un artículo del carrito
export const eliminarArticulo = async (articuloId) => {
  try {
    const response = await axios.delete(`/carrito/eliminar/${articuloId}`);
    return response.data;
  } catch (error) {
    console.error('Error al eliminar el artículo del carrito:', error);
    return null;
  }
};

// Función para vaciar el carrito
export const vaciarCarrito = async () => {
  try {
    const response = await axios.delete('/carrito/vaciar');
    return response.data;
  } catch (error) {
    console.error('Error al vaciar el carrito:', error);
    return null;
  }
};
