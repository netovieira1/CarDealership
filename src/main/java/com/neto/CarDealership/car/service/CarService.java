package com.neto.CarDealership.car.service;

import com.neto.CarDealership.car.CarModel;
import com.neto.CarDealership.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //CREATE
    public CarModel create(CarModel car){
        return carRepository.save(car);
    }

    //GET
    public List<CarModel> findAll(){
        return carRepository.findAll();
    }

    //GET BY ID
    public CarModel findById(Long id, CarModel car){
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    //UPDATE
    public CarModel updateById(Long id, CarModel updatedCar){
        CarModel existingCar = carRepository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado."));

        existingCar.setName(updatedCar.getName());
        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setColor(updatedCar.getColor());
        existingCar.setOwner(updatedCar.getOwner());
        existingCar.setYear(updatedCar.getYear());
        return carRepository.save(existingCar);
    }
    //DELETE
    public void deleteById(Long id){
        carRepository.deleteById(id);
    }
}
