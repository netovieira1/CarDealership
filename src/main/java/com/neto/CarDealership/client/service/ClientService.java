package com.neto.CarDealership.client.service;

import com.neto.CarDealership.client.model.ClientModel;
import com.neto.CarDealership.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //CREATE
    public ClientModel create(ClientModel client){
        return clientRepository.save(client);
    }

    //GET ALL
    public List<ClientModel> findAll(){
        return clientRepository.findAll();
    }

    //GET BY ID
    public ClientModel findById(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //UPDATE
    public ClientModel updateById(Long id, ClientModel clientUpdated){
        ClientModel existingClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        existingClient.setName(clientUpdated.getName());
        existingClient.setEmail(clientUpdated.getEmail());
        existingClient.setPhone(clientUpdated.getPhone());
        existingClient.setCpf(clientUpdated.getCpf());
        existingClient.setCars(clientUpdated.getCars());
        return clientRepository.save(existingClient);

    }

    //DELETE
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
