// src/services/RentalService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/rentals'; // Backend API URL'inizi buraya girin

const RentalService = {
    getRentals: async () => {
        const response = await axios.get(API_URL);
        return response.data;
    },
};

export default RentalService;
