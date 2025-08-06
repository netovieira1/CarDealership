package com.neto.CarDealership.user.mappers;

import com.neto.CarDealership.user.dto.UserDTO;
import com.neto.CarDealership.user.dto.UserResponseDTO;
import com.neto.CarDealership.user.model.UserModel;

public class UserMapper {

    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();

        userModel.setUsername(userDTO.getUsername());
        userModel.setName(userDTO.getName());
        userModel.setPassword(userDTO.getPassword());
        userModel.setEmail(userDTO.getEmail());
        userModel.setCpf(userDTO.getCpf());
        userModel.setRole(userDTO.getRole());
        return userModel;
    }

    public UserResponseDTO map(UserModel userModel){
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(userModel.getId());
        userResponseDTO.setUsername(userModel.getUsername());
        userResponseDTO.setName(userModel.getName());
        userResponseDTO.setEmail(userModel.getEmail());
        userResponseDTO.setCpf(userModel.getCpf());
        userResponseDTO.setRole(userModel.getRole());
        return userResponseDTO;
    }
}
