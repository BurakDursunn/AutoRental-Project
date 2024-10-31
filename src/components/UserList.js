// src/components/UserList.js
import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS
import UserService from '../services/UserService';

const UserList = () => {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true); // Yükleniyor durumu için

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const userList = await UserService.getUsers();
                setUsers(userList);
            } catch (error) {
                console.error('Error fetching users:', error);
            } finally {
                setLoading(false); // Yükleme tamamlandı
            }
        };
        fetchUsers();
    }, []);

    return (
        <div className="container mt-5">
            <h2 className="mb-4 text-center">User List</h2>
            {loading ? (
                <div className="text-center">Loading users...</div>
            ) : (
                <table className="table table-bordered table-hover shadow">
                    <thead className="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.length > 0 ? (
                            users.map((user) => (
                                <tr key={user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.username}</td>
                                    <td>{user.email}</td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="3" className="text-center">No users available</td>
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

export default UserList;
