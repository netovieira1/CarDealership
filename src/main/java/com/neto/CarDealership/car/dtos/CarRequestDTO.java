package com.neto.CarDealership.car.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados parar cadastra um carro")
public class CarRequestDTO {

    @NotBlank(message = "O nome do carro é obrigatório")
    @Schema(description = "Nome do carro", example = "Palio")
    private String name;

    @NotBlank(message = "O nome da marca é obrigatório")
    @Schema(description = "Marca do carro", example = "Fiat")
    private String brand;

    @NotBlank(message = "O nome da modelo é obrigatório")
    @Schema(description = "Modelo do carro", example = "Sedan")
    private String model;

    @NotNull(message = "O ano do carro é obrigatório")
    @Schema(description = "Ano do carro", example = "2022")
    private Integer carYear;

    @NotBlank(message = "A cor do carro é obrigatória")
    @Schema(description = "Cor do carro", example = "Preta")
    private String color;

    @NotBlank(message = "A placa do carro é obrigatória")
    @Schema(description = "Placa do carro", example = "POJ1405")
    private String plate;

    @NotNull(message = "O clientId não pode ser nulo")
    @Schema(description = "Cliente do ID que alugou o carro", example = "4")
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
