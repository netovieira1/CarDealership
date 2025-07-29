package com.neto.CarDealership.client.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Informações detalhadas de um cliente")
public class ClientDTO {

    @Schema(description = "ID do cliente", example = "15")
    private Long id;

    @Schema(description = "Nome do cliente", example = "Joao Silva")
    private String name;

    @Schema(description = "Email do cliente", example = "joao@email.com")
    private String email;

    @Schema(description = "CPF do cliente", example = "12345678909")
    private String cpf;

    @Schema(description = "Telefone do cliente", example = "981789090")
    private String phone;

    @Schema(description = "Ids dos carros alugados pelo cliente", example = "[4, 6]")
    private List<Long> rentalCars;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getRentalCars() {
        return rentalCars;
    }

    public void setRentalCars(List<Long> rentalCars) {
        this.rentalCars = rentalCars;
    }
}
