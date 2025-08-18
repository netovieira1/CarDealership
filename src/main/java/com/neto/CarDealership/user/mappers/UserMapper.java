package com.neto.CarDealership.user.mappers;

import com.neto.CarDealership.user.dto.RegisterRequestDTO;
import com.neto.CarDealership.user.dto.UserDTO;
import com.neto.CarDealership.user.dto.UserResponseDTO;
import com.neto.CarDealership.user.enums.Role;
import com.neto.CarDealership.user.model.UserModel;
import org.springframework.stereotype.Component;

@Component
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

    public UserModel map(RegisterRequestDTO dto) {
        UserModel model = new UserModel();
        model.setUsername(dto.getUsername());
        model.setName(dto.getName());
        model.setPassword(dto.getPassword());
        model.setEmail(dto.getEmail());
        model.setCpf(dto.getCpf());
        // usa Role.USER se vier nulo
        model.setRole(dto.getRole() != null ? dto.getRole() : Role.USER);
        return model;
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

    public void updateModelFromDto(UserDTO userDTO, UserModel userModel){
        if (userDTO.getUsername() != null && !userDTO.getUsername().isBlank()){
            userModel.setUsername(userDTO.getUsername());
        }
        if (userDTO.getName() != null){
            userModel.setName(userDTO.getName());
        }
        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()){
            userModel.setPassword(userDTO.getPassword());
        }
        if (userDTO.getEmail() != null){
            userModel.setEmail(userDTO.getEmail());
        }
        if (userDTO.getCpf() != null){
            userModel.setCpf(userDTO.getCpf());
        }
        if (userDTO.getRole() != null){
            userModel.setRole(userDTO.getRole());
        }
    }
}
