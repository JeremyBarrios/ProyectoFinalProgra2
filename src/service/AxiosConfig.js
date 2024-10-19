// src/service/AxiosConfig.js
import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8080',  // Aquí se establece la URL base de tu backend Spring Boot
    headers: {
        'Content-Type': 'application/json'
    }
});

export default instance;
