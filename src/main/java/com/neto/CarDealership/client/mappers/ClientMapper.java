package com.neto.CarDealership.client.mappers;

import com.neto.CarDealership.car.mappers.CarMapper;
import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.client.dtos.ClientDTO;
import com.neto.CarDealership.client.dtos.ClientRequestDTO;
import com.neto.CarDealership.client.model.ClientModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientModel map(ClientDTO clientDTO){
        ClientModel clientModel = new ClientModel();

        clientModel.setId(clientDTO.getId());
        clientModel.setName(clientDTO.getName());
        clientModel.setEmail(clientDTO.getEmail());
        clientModel.setCpf(clientDTO.getCpf());
        clientModel.setPhone(clientDTO.getPhone());
        return clientModel;
    }

    public ClientDTO map(ClientModel clientModel){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(clientModel.getId());
        clientDTO.setName(clientModel.getName());
        clientDTO.setEmail(clientModel.getEmail());
        clientDTO.setCpf(clientModel.getCpf());
        clientDTO.setPhone(clientModel.getPhone());

        List<Long> rentalCars = clientModel.getCars().stream()
                .map(CarModel::getId)
                .collect(Collectors.toList());
        clientDTO.setRentalCars(rentalCars);
        return clientDTO;
    }

    public ClientModel map(ClientRequestDTO clientRequestDTO){
        ClientModel clientModel = new ClientModel();

        clientModel.setName(clientRequestDTO.getName());
        clientModel.setEmail(clientRequestDTO.getEmail());
        clientModel.setCpf(clientRequestDTO.getCpf());
        clientModel.setPhone(clientRequestDTO.getPhone());

        return clientModel;
    }
}
