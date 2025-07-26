package com.neto.CarDealership.car.mappers;

import com.neto.CarDealership.car.dtos.CarDTO;
import com.neto.CarDealership.car.dtos.CarRequestDTO;
import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.client.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDTO map(CarModel carModel) {
        CarDTO carDTO = new CarDTO();

        carDTO.setId(carModel.getId());
        carDTO.setName(carModel.getName());
        carDTO.setBrand(carModel.getBrand());
        carDTO.setModel(carModel.getModel());
        carDTO.setCarYear(carModel.getCarYear());
        carDTO.setColor(carModel.getColor());
        if (carModel.getOwner() != null){
            carDTO.setClientId(carModel.getOwner().getId());
        }
        return carDTO;
    }

    public CarModel map(CarDTO carDTO, ClientModel owner){
        CarModel carModel = new CarModel();

        carModel.setId(carDTO.getId());
        carModel.setName(carDTO.getName());
        carModel.setBrand(carDTO.getBrand());
        carModel.setModel(carDTO.getModel());
        carModel.setCarYear(carDTO.getCarYear());
        carModel.setColor(carDTO.getColor());
        carModel.setOwner(owner);
        return carModel;
    }

    public CarModel map(CarRequestDTO carRequestDTO, ClientModel owner){
        CarModel carModel = new CarModel();

        carModel.setName(carRequestDTO.getName());
        carModel.setBrand(carRequestDTO.getBrand());
        carModel.setModel(carRequestDTO.getModel());
        carModel.setCarYear(carRequestDTO.getCarYear());
        carModel.setColor(carRequestDTO.getColor());
        carModel.setOwner(owner);
        return carModel;
    }
}
