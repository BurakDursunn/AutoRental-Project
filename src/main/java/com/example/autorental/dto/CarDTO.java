package com.example.autorental.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
