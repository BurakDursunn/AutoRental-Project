package com.example.autorental.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalDTO {
    private Long id;
    private Long userId;
    private Long carId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
