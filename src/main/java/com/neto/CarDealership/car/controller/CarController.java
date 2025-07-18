package com.neto.CarDealership.car.controller;

import com.neto.CarDealership.car.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //CREATE

    //GET ALL

    //GET BY ID

    //UPDATE

    //DELETE
}
