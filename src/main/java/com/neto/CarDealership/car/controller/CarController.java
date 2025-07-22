package com.neto.CarDealership.car.controller;

import com.neto.CarDealership.car.dtos.CarDTO;
import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.car.service.CarService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CarDTO carDTO){
        CarDTO newCar = carService.create(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Carro cadastrado com sucesso");
    }

    //GET ALL
    @GetMapping("/list")
    public ResponseEntity<List<CarDTO>> getAll(){
        List<CarDTO> cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }

    //GET BY ID
    @GetMapping("/list/{id}")
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
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody CarDTO updatedCar){
        CarDTO car = carService.updateById(id, updatedCar);
        if (car != null){
            return ResponseEntity.ok(car);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if (carService.findById(id) != null){
            carService.deleteById(id);
            return ResponseEntity.ok().body("Carro deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
    }
}
