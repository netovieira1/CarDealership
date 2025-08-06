package com.neto.CarDealership.user.service;

import com.neto.CarDealership.user.dto.UserDTO;
import com.neto.CarDealership.user.dto.UserResponseDTO;
import com.neto.CarDealership.user.enums.Role;
import com.neto.CarDealership.user.mappers.UserMapper;
import com.neto.CarDealership.user.model.UserModel;
import com.neto.CarDealership.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    //CREATE
    public UserResponseDTO createUser(UserDTO userDTO){
        if (userRepository.existsByUsername(userDTO.getUsername())){
            throw new RuntimeException("Username já está em uso");
        }
        //DTO -> MODEL
        UserModel userModel = userMapper.map(userDTO);
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        if (userDTO.getRole() == null){
            userModel.setRole(Role.USER);
        }
        // 2) salva e obtém os dados gerados (ID, timestamps)
        UserModel saved = userRepository.save(userModel);
        return userMapper.map(saved);
    }

    //GETALL

    //GETBYID

    //UPDTATE

    //DELETE
}
