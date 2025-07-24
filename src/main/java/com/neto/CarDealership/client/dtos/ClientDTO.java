package com.neto.CarDealership.client.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
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
