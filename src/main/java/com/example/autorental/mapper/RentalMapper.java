package com.example.autorental.mapper;

import com.example.autorental.dto.RentalDTO;
import com.example.autorental.model.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {
    public RentalDTO toDTO(Rental rental) {
        RentalDTO dto = new RentalDTO();
        dto.setId(rental.getId());
        dto.setUserId(rental.getUser().getId());
        dto.setCarId(rental.getCar().getId());
        dto.setStartDate(rental.getStartDate());
        dto.setEndDate(rental.getEndDate());
        return dto;
    }

    public Rental toEntity(RentalDTO dto) {
        Rental rental = new Rental();
        rental.setId(dto.getId());
        // Kullanıcı ve araç nesneleri için eklemeler yapmalısınız
        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        return rental;
    }
}

