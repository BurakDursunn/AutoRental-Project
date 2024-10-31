// src/services/UserService.js
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/users'; // Backend API URL'si

const UserService = {
    getUsers: async () => {
        try {
            const response = await axios.get(BASE_URL);
            return response.data; // Kullanıcı verilerini döndür
        } catch (error) {
            console.error('Error fetching users:', error);
            throw error;
        }
    },
};

export default UserService;
