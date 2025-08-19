package com.neto.CarDealership.car.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Schema(description = "Informações detalhadas dos carros")
public class CarDTO {

    @Schema(description = "ID do carro", example = "1")
    private Long id;

    @Schema(description = "Nome do carro", example = "Palio")
    private String name;

    @Schema(description = "Marca do carro", example = "Fiat")
    private String brand;

    @Schema(description = "Modelo do carro", example = "Sedan")
    private String model;

    @Schema(description = "Ano do carro", example = "2022")
    private Integer carYear;

    @Schema(description = "Cor do carro", example = "Preta")
    private String color;

    @Schema(description = "Placa do carro", example = "POJ1405")
    private String plate;

    @Schema(description = "Cliente do ID que alugou o carro", example = "4")
    private Long clientId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
