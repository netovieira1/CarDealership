package com.neto.CarDealership.client.controller;

import ch.qos.logback.core.net.server.Client;
import com.neto.CarDealership.client.dtos.ClientDTO;
import com.neto.CarDealership.client.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //CREATE
    public ResponseEntity<String> create(@RequestBody ClientDTO client){
        ClientDTO newClient = clientService.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado com sucesso");
    }

    //GET ALL
    public ResponseEntity<List<ClientDTO>> getAll(){
        List<ClientDTO> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }

    //GET BY ID
    public ResponseEntity<?> getById(Long id){
        ClientDTO client = clientService.findById(id);

        if(client != null){
            return ResponseEntity.ok(client);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    //UPATE
    public ResponseEntity<?> updateById(Long id, ClientDTO clientUpdated){
        ClientDTO client = clientService.updateById(id, clientUpdated);
        if (client != null){
            ResponseEntity.ok(client);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        return null;
    }

    //DELETE
    public ResponseEntity<String>  deleteById(Long id){
        if(clientService.findById(id) != null){
            clientService.deleteById(id);
            return ResponseEntity.ok("Cliente deletado com sucesso.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }
}
