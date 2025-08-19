package com.neto.CarDealership.user.controller;

import com.neto.CarDealership.user.dto.RegisterRequestDTO;
import com.neto.CarDealership.user.dto.UserDTO;
import com.neto.CarDealership.user.dto.UserResponseDTO;
import com.neto.CarDealership.user.mappers.UserMapper;
import com.neto.CarDealership.user.model.UserModel;
import com.neto.CarDealership.user.service.AuthService;
import com.neto.CarDealership.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "Usuários", description = "Operações relacionadas ao usuários do sistema")

public class UserController {

    private final  UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @Operation(summary = "Criar usuários do  sistema")
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody RegisterRequestDTO requestDTO){
        UserResponseDTO userResponseDTO = userService.createUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

   @GetMapping("/all")
   @Operation(summary = "Listar todos os usuários do sistema")
   public ResponseEntity<List<UserResponseDTO>> getAll(){
            List<UserResponseDTO> userResponseDTO = userService.getAll();
            return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar os usuários do sistema por id")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        UserResponseDTO userResponseDTO  = userService.findById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualizar os usuários do sistema por id")
    public ResponseEntity<UserResponseDTO> updateById(@PathVariable Long id, @RequestBody UserDTO userDTO){
        UserResponseDTO updatedUser = userService.updateById(id,userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletar os usuários do sistema por id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
