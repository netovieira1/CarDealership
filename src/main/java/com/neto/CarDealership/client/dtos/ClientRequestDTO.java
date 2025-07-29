package com.neto.CarDealership.client.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para criar um cliente")
public class ClientRequestDTO {

    @Schema(description = "Nome do cliente", example = "Joao Silva")
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3,  max = 100, message = "O nome dever ter entre 3 e 100 caracteres")
    private String name;

    @Schema(description = "Email do cliente", example = "joao@email.com")
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @Schema(description = "CPF do cliente", example = "12345678901")
    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos")
    private String cpf;

    @Schema(description = "Telefone do  cliente", example = "998764569")
    @NotBlank(message = "O Telefone é obrigatório")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 dígitos")
    private String phone;

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
}
