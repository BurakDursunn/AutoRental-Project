// src/App.js
import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS importu
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'; // React Router importları
import CarList from './components/CarList';
import UserList from './components/UserList';
import RentalList from './components/RentalList'; // RentalList bileşenini import et
import CarService from './services/CarService';

const App = () => {
    const [cars, setCars] = useState([]);

    useEffect(() => {
        // Sayfa yüklendiğinde araçları al
        const fetchCars = async () => {
            const carList = await CarService.getCars();
            setCars(carList);
        };
        fetchCars();
    }, []);

    return (
        <Router>
            <div className="container mt-5">
                <h1 className="text-center">Car Rental System</h1>
                <nav className="mb-4">
                    <ul className="nav nav-pills justify-content-center">
                        <li className="nav-item">
                            <Link className="nav-link" to="/cars">Cars</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/users">Users</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/rentals">Rentals</Link>
                        </li>
                    </ul>
                </nav>

                <Routes>
                    <Route path="/cars" element={<CarList cars={cars} />} />
                    <Route path="/users" element={<UserList />} />
                    <Route path="/rentals" element={<RentalList />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
