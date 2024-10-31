// src/components/RentalList.js
import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS
import RentalService from '../services/RentalService';

const RentalList = () => {
    const [rentals, setRentals] = useState([]);
    const [loading, setLoading] = useState(true); // Yükleniyor durumu için

    useEffect(() => {
        const fetchRentals = async () => {
            try {
                const rentalList = await RentalService.getRentals();
                setRentals(rentalList);
            } catch (error) {
                console.error('Error fetching rentals:', error);
            } finally {
                setLoading(false); // Yükleme tamamlandı
            }
        };
        fetchRentals();
    }, []);

    return (
        <div className="container mt-5">
            <h2 className="mb-4 text-center">Rental List</h2>
            {loading ? (
                <div className="text-center">Loading rentals...</div>
            ) : (
                <table className="table table-bordered table-hover shadow">
                    <thead className="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>User ID</th>
                            <th>Car ID</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {rentals.length > 0 ? (
                            rentals.map((rental) => (
                                <tr key={rental.id}>
                                    <td>{rental.id}</td>
                                    <td>{rental.userId}</td>
                                    <td>{rental.carId}</td>
                                    <td>{new Date(rental.startDate).toLocaleDateString()}</td>
                                    <td>{new Date(rental.endDate).toLocaleDateString()}</td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="5" className="text-center">No rentals available</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            )}
            <style jsx>{`
                .table {
                    border-radius: 0.5rem;
                    overflow: hidden; /* Kenarları yuvarlatmak için */
                }

                .table th, .table td {
                    vertical-align: middle; /* İçeriklerin ortalanması için */
                }

                .table-dark th {
                    background-color: #343a40; /* Koyu arka plan rengi */
                    color: white; /* Başlık metin rengi */
                }

                .shadow {
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Gölgelendirme efekti */
                }

                .text-center {
                    text-align: center; /* Metni ortalamak için */
                }

                .mt-5 {
                    margin-top: 3rem; /* Üstten boşluk için */
                }

                .mb-4 {
                    margin-bottom: 1.5rem; /* Alttan boşluk için */
                }
            `}</style>
        </div>
    );
};

export default RentalList;
