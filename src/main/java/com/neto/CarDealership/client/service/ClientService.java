package com.neto.CarDealership.client.service;

import com.neto.CarDealership.client.dtos.ClientDTO;
import com.neto.CarDealership.client.mappers.ClientMapper;
import com.neto.CarDealership.client.model.ClientModel;
import com.neto.CarDealership.client.repository.ClientRepository;
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
    public ClientDTO create(ClientDTO clientDTO){
         //Mapear o model para um DTO
        ClientModel client = clientMapper.map(clientDTO);
        //Salvar o model
        client = clientRepository.save(client);
        //Retornar mapeado
        return clientMapper.map(client);

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
    public ClientDTO updateById(Long id, ClientDTO clientDTO){
    Optional<ClientModel> existedClient = clientRepository.findById(id);
    if (existedClient.isPresent()){
        ClientModel updatedClient = clientMapper.map(clientDTO);
        updatedClient.setId(id);
        ClientModel savedClient = clientRepository.save(updatedClient);
        return clientMapper.map(savedClient);
    }
    return null;
    }

    //DELETE
    public void deleteById(Long id){
        if (clientRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado");
        }
        clientRepository.deleteById(id);
    }
}
