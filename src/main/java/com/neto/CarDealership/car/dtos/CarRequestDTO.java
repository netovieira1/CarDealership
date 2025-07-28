package com.neto.CarDealership.car.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CarRequestDTO {

    @NotBlank(message = "O nome do carro é obrigatório")
    private String name;

    @NotBlank(message = "O nome da marca é obrigatório")
    private String brand;

    @NotBlank(message = "O nome da modelo é obrigatório")
    private String model;

    @NotNull(message = "O ano do carro é obrigatório")
    private Integer carYear;

    @NotBlank(message = "A cor do carro é obrigatória")
    private String color;

    @Size(min = 7, max = 7, message = "A placa deve conter 7 dígitos")
    @NotBlank(message = "A placa do carro é obrigatória")
    private String plate;

    @NotNull(message = "O clientId não pode ser nulo")
    private Long clientId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
