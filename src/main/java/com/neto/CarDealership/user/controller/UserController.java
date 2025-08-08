package com.neto.CarDealership.user.controller;

import com.neto.CarDealership.user.dto.UserDTO;
import com.neto.CarDealership.user.dto.UserResponseDTO;
import com.neto.CarDealership.user.mappers.UserMapper;
import com.neto.CarDealership.user.model.UserModel;
import com.neto.CarDealership.user.service.AuthService;
import com.neto.CarDealership.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final  UserService userService;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserDTO userDTO){
        UserResponseDTO userResponseDTO = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

   @GetMapping("/all")
        public ResponseEntity<List<UserResponseDTO>> getAll(){
            List<UserResponseDTO> userResponseDTO = userService.getAll();
            return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        UserResponseDTO userResponseDTO  = userService.findById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateById(@PathVariable Long id, @RequestBody UserDTO userDTO){
        UserResponseDTO updatedUser = userService.updateById(id,userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
