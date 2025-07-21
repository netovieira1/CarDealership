package com.neto.CarDealership.car.service;

import com.neto.CarDealership.car.dtos.CarDTO;
import com.neto.CarDealership.car.mappers.CarMapper;
import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    //CREATE
    public CarDTO create(CarDTO carDTO){
        //Mapear o model para um DTO
        CarModel car = carMapper.map(carDTO);
        car = carRepository.save(car);
        return carMapper.map(car);
    }

    //GET ALL
    public List<CarDTO> findAll(){
        List<CarModel> cars = carRepository.findAll();
        return cars.stream()
                .map(carMapper::map)
                .collect(Collectors.toList());
    }

    //GET BY ID
    public CarDTO findById(Long id){
        Optional<CarModel> car = carRepository.findById(id);
        return car.map(carMapper::map).orElseThrow(() -> new RuntimeException("Carro não encontrado."));
    }

    //UPDATE
    public CarDTO updateById(Long id, CarDTO carDTO){
        Optional<CarModel> existedCar = carRepository.findById(id);
        if (existedCar.isPresent()){
            CarModel updatedCar = carMapper.map(carDTO);
            updatedCar.setId(id);
            CarModel savedCar = carRepository.save(updatedCar);
            return carMapper.map(savedCar);
        }
        return null;
    }
    //DELETE
    public void deleteById(Long id){
        if (!carRepository.existsById(id)){
            throw new RuntimeException("Carro não encontrado");
        }
        carRepository.deleteById(id);
    }
}
