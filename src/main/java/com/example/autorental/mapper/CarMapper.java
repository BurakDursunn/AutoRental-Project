package com.example.autorental.mapper;

import com.example.autorental.dto.CarDTO;
import com.example.autorental.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDTO toDTO(Car car) {
        if (car == null) {
            return null;
        }
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setPrice(car.getPrice());
        return carDTO;
    }

    public Car toEntity(CarDTO carDTO) {
        if (carDTO == null) {
            return null;
        }
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        return car;
    }
}
