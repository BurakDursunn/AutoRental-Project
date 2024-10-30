package com.example.autorental.service;

import com.example.autorental.dto.RentalDTO;
import com.example.autorental.mapper.RentalMapper;
import com.example.autorental.model.Rental;
import com.example.autorental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    @Autowired
    public RentalService(RentalRepository rentalRepository, RentalMapper rentalMapper) {
        this.rentalRepository = rentalRepository;
        this.rentalMapper = rentalMapper;
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
        Rental rental = rentalMapper.toEntity(rentalDTO);
        return rentalMapper.toDTO(rentalRepository.save(rental));
    }

    public RentalDTO updateRental(Long id, RentalDTO rentalDTO) {
        Rental rental = rentalMapper.toEntity(rentalDTO);
        rental.setId(id);
        return rentalMapper.toDTO(rentalRepository.save(rental));
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
