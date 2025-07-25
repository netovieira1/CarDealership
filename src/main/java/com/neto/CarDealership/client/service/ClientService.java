package com.neto.CarDealership.client.service;

import com.neto.CarDealership.client.dtos.ClientDTO;
import com.neto.CarDealership.client.dtos.ClientRequestDTO;
import com.neto.CarDealership.client.mappers.ClientMapper;
import com.neto.CarDealership.client.model.ClientModel;
import com.neto.CarDealership.client.repository.ClientRepository;
import com.neto.CarDealership.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    //CREATE
    public ClientDTO create(ClientRequestDTO clientRequestDTO){
         //Mapear o model para um DTO
        ClientModel model = clientMapper.map(clientRequestDTO);
        //Salvar o model
        ClientModel saved = clientRepository.save(model);
        //Retornar mapeado
        return clientMapper.map(saved);
    }

    //GET ALL
    public List<ClientDTO> findAll(){
        List<ClientModel> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::map)
                .collect(Collectors.toList());
    }

    //GET BY ID
    public ClientDTO findById(Long id){
        Optional<ClientModel> client = clientRepository.findById(id);
        return client.map(clientMapper::map).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //UPDATE
    public ClientDTO updateById(Long id, ClientRequestDTO clientRequestDTO){
    ClientModel clientModel = clientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado"));

    clientModel.setName(clientRequestDTO.getName());
    clientModel.setEmail(clientRequestDTO.getEmail());
    clientModel.setCpf(clientRequestDTO.getCpf());
    clientModel.setPhone(clientRequestDTO.getPhone());

    ClientModel updated = clientRepository.save(clientModel);
    return clientMapper.map(updated);
    }

    //DELETE
    public boolean deleteById(Long id){
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isPresent()){
            clientRepository.delete(client.get());
            return true;
        }
        return false;
    }
}
