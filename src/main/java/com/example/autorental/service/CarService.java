package com.example.autorental.service;


import com.example.autorental.dto.CarDTO;
import com.example.autorental.exception.CarNotFoundException;
import com.example.autorental.mapper.CarMapper;
import com.example.autorental.model.Car;
import com.example.autorental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(carMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CarDTO getCarById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toDTO)
                .orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + id));
    }


    public CarDTO createCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        return carMapper.toDTO(carRepository.save(car));
    }

    public CarDTO updateCar(Long id, CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        car.setId(id);
        return carMapper.toDTO(carRepository.save(car));
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
