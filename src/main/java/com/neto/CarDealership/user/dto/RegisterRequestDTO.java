package com.neto.CarDealership.user.dto;

import com.neto.CarDealership.user.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Informações detalhadas de um usuário")
public class RegisterRequestDTO {

    @Schema(description = "Usernme do usuário", example = "joaosilva")
    private String username;

    @Schema(description = "Senha do usuário", example = "123456")
    private String password;

    @Schema(description = "Nome do usuário", example = "João Silva")
    private String name;

    @Schema(description = "email do usuário", example = "joao@email.com")
    private String email;

    @Schema(description = "CPF do usuário", example = "12345678900")
    private String cpf;

    @Schema(description = "Role de permissão do usuário", example = "ADMIN ou USER")
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
