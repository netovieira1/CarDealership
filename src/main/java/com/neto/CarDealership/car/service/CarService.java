package com.neto.CarDealership.car.service;

import com.neto.CarDealership.car.dtos.CarDTO;
import com.neto.CarDealership.car.dtos.CarRequestDTO;
import com.neto.CarDealership.car.mappers.CarMapper;
import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.car.repository.CarRepository;
import com.neto.CarDealership.client.model.ClientModel;
import com.neto.CarDealership.client.repository.ClientRepository;
import com.neto.CarDealership.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final ClientRepository clientRepository;

    public CarService(CarRepository carRepository, CarMapper carMapper, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.clientRepository = clientRepository;
    }

    //CREATE
    public CarDTO create(CarRequestDTO carRequestDTO){
        ClientModel owner = clientRepository.findById(carRequestDTO.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        //Mapear o model para um DTO
        CarModel car = carMapper.map(carRequestDTO, owner);
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
    public CarDTO updateById(Long id, CarRequestDTO carRequestDTO){
        CarModel carModel = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro com o ID " + id + " não encontrado"));

        if (carRequestDTO.getName() != null) carModel.setName(carRequestDTO.getName());
        if (carRequestDTO.getBrand() != null) carModel.setBrand(carRequestDTO.getBrand());
        if (carRequestDTO.getModel() != null) carModel.setModel(carRequestDTO.getModel());
        if (carRequestDTO.getCarYear() != null) carModel.setCarYear(carRequestDTO.getCarYear());
        if (carRequestDTO.getColor() != null) carModel.setColor(carRequestDTO.getColor());
        if (carRequestDTO.getClientId() != null){
            ClientModel client = clientRepository.findById(carRequestDTO.getClientId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente com o ID " + carRequestDTO.getClientId() + " não encontrado."));
            carModel.setOwner(client);
        }
        CarModel updated = carRepository.save(carModel);
        return carMapper.map(updated);
    }
    //DELETE
    public void deleteById(Long id){
        if (!carRepository.existsById(id)){
            throw new ResourceNotFoundException("Carro não encontrado");
        }
        carRepository.deleteById(id);
    }
}
