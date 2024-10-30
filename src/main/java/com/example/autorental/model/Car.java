package com.example.autorental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
