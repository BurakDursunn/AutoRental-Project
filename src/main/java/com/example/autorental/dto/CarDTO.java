package com.example.autorental.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private Long id;

    @NotBlank(message = "Brand is mandatory")
    @Size(max = 100)
    private String brand;

    @NotBlank(message = "Model is mandatory")
    @Size(max = 100)
    private String model;

    @NotNull(message = "Year is mandatory")
    private Integer year;

    @NotNull(message = "Price is mandatory")
    private Double price;

}
