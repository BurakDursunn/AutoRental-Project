package com.example.autorental.service;

import com.example.autorental.dto.RentalDTO;
import com.example.autorental.exception.CarNotFoundException;
import com.example.autorental.exception.ResourceNotFoundException;
import com.example.autorental.exception.UserNotFoundException;
import com.example.autorental.mapper.RentalMapper;
import com.example.autorental.model.Rental;
import com.example.autorental.model.User;
import com.example.autorental.model.Car;
import com.example.autorental.repository.RentalRepository;
import com.example.autorental.repository.UserRepository;
import com.example.autorental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final UserRepository userRepository;
    private final CarRepository carRepository;


    public RentalService(RentalRepository rentalRepository, RentalMapper rentalMapper,
                         UserRepository userRepository, CarRepository carRepository) {
        this.rentalRepository = rentalRepository;
        this.rentalMapper = rentalMapper;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    public List<RentalDTO> getAllRentals() {
        return rentalRepository.findAll().stream()
                .map(rentalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RentalDTO> getRentalById(Long id) {
        return rentalRepository.findById(id).map(rentalMapper::toDTO);
    }

    public RentalDTO createRental(RentalDTO rentalDTO) {
        // Kullanıcıyı getir veya yoksa hata fırlat
        User user = userRepository.findById(rentalDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + rentalDTO.getUserId()));

        // Aracı getir veya yoksa hata fırlat
        Car car = carRepository.findById(rentalDTO.getCarId())
                .orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + rentalDTO.getCarId()));

        // Rental DTO'yu Rental entity'ye dönüştürürken User ve Car'ı dahil et
        Rental rental = rentalMapper.toEntity(rentalDTO, user, car);

        // Rental kaydını kaydet ve DTO olarak geri döndür
        Rental savedRental = rentalRepository.save(rental);
        return rentalMapper.toDTO(savedRental);
    }


    public RentalDTO updateRental(Long id, RentalDTO rentalDTO) {
        Rental existingRental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found with ID: " + id));


        User user = userRepository.findById(rentalDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + rentalDTO.getUserId()));
        Car car = carRepository.findById(rentalDTO.getCarId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with ID: " + rentalDTO.getCarId()));


        Rental updatedRental = rentalMapper.toEntity(rentalDTO, user, car);
        updatedRental.setId(existingRental.getId());

        return rentalMapper.toDTO(rentalRepository.save(updatedRental));
    }

    public void deleteRental(Long id) {
        if (!rentalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rental not found with ID: " + id);
        }
        rentalRepository.deleteById(id);
    }
}
