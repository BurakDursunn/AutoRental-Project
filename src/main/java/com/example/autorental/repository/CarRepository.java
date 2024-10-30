package com.example.autorental.repository;

import com.example.autorental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // İsteğe bağlı özel sorgular burada tanımlanabilir
}
