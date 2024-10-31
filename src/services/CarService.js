// src/services/CarService.js
const API_URL = 'http://localhost:8080/api/cars'; // API URL

const CarService = {
    getCars: async () => {
        const response = await fetch(API_URL);
        return await response.json();
    },
    createCar: async (car) => {
        await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(car),
        });
    },
};

export default CarService;
