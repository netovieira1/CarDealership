package com.neto.CarDealership.client.controller;

import com.neto.CarDealership.client.dtos.ClientDTO;
import com.neto.CarDealership.client.dtos.ClientRequestDTO;
import com.neto.CarDealership.client.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Tag(name = "Clientes", description = "Operações relacionadas ao clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    @Operation(summary = "Criar clientes")
    public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientRequestDTO client){
        ClientDTO newClient = clientService.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    @GetMapping("/list")
    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<Page<ClientDTO>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            Pageable pageable
    ){
        Page<ClientDTO> clients = clientService.findAll(name, email, pageable);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Listar cliente por id")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ClientDTO client = clientService.findById(id);
        if(client != null){
            return ResponseEntity.ok(client);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Fazer alterações nos clientes")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ClientRequestDTO clientUpdated){
        ClientDTO client = clientService.updateById(id, clientUpdated);
        if (client != null){
            return ResponseEntity.ok(client);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletar clientes")
    public ResponseEntity<Void>  deleteById(@PathVariable Long id){
        boolean deleted = clientService.deleteById(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
