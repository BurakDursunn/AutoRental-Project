// src/components/CarList.js
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; 

const CarList = ({ cars }) => {
    return (
        <div className="container mt-5">
            <h2 className="mb-4 text-center">Car List</h2>
            <table className="table table-bordered table-hover shadow">
                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>Year</th>
                    </tr>
                </thead>
                <tbody>
                    {cars.length > 0 ? (
                        cars.map((car) => (
                            <tr key={car.id}>
                                <td>{car.id}</td>
                                <td>{car.brand}</td>
                                <td>{car.model}</td>
                                <td>{car.year}</td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="4" className="text-center">No cars available</td>
                        </tr>
                    )}
                </tbody>
            </table>
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

export default CarList;
