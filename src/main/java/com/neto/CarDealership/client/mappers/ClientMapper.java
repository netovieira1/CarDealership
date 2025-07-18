package com.neto.CarDealership.client.mappers;

import com.neto.CarDealership.client.dtos.ClientDTO;
import com.neto.CarDealership.client.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO clientDTO(ClientModel clientModel){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(clientModel.getId());
        clientDTO.setName(clientModel.getName());
        clientDTO.setEmail(clientModel.getEmail());
        clientDTO.setCpf(clientModel.getCpf());
        clientDTO.setPhone(clientModel.getPhone());
        return clientDTO;
    }

    public ClientModel clientModel(ClientDTO clientDTO){
        ClientModel clientModel = new ClientModel();

        clientModel.setId(clientDTO.getId());
        clientModel.setName(clientDTO.getName());
        clientModel.setEmail(clientDTO.getEmail());
        clientModel.setCpf(clientDTO.getCpf());
        clientModel.setPhone(clientDTO.getPhone());
        return clientModel;
    }
}
