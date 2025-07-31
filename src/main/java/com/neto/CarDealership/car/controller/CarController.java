package com.neto.CarDealership.car.controller;

import com.neto.CarDealership.car.dtos.CarDTO;
import com.neto.CarDealership.car.dtos.CarRequestDTO;
import com.neto.CarDealership.car.service.CarService;
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
@RequestMapping("/cars")
@Tag(name = "Cars", description = "Operações relacionadas aos carros")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //CREATE
    @PostMapping("/create")
    @Operation(summary = "Cadastrar carros")
    public ResponseEntity<CarDTO> create(@RequestBody @Valid CarRequestDTO carRequestDTO){
        CarDTO newCar = carService.create(carRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    //GET ALL
    @GetMapping("/list")
    @Operation(summary = "Listar todos os carros")
    public ResponseEntity<Page<CarDTO>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String plate,
            Pageable pageable){
        Page<CarDTO> cars = carService.findAll(name, plate, pageable);
        return ResponseEntity.ok(cars);
    }

    //GET BY ID
    @GetMapping("/list/{id}")
    @Operation(summary = "Listar carro por id")
    public ResponseEntity<?> getById(@PathVariable Long id){
        CarDTO car = carService.findById(id);
        if(car != null){
            return ResponseEntity.ok(car);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
    }

    //UPDATE
    @PutMapping("/update/{id}")
    @Operation(summary = "Fazer alterações nos carros")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid CarRequestDTO updatedCar){
        CarDTO car = carService.updateById(id, updatedCar);
        if (car != null){
            return ResponseEntity.ok(car);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletar carros")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if (carService.findById(id) != null){
            carService.deleteById(id);
            return ResponseEntity.ok().body("Carro deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
    }
}
