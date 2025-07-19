package com.neto.CarDealership.car.mappers;

import com.neto.CarDealership.car.dtos.CarDTO;
import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.client.dtos.ClientDTO;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    CarDTO carModel(CarModel carModel) {
        CarDTO carDTO = new CarDTO();

        carDTO.setId(carModel.getId());
        carDTO.setName(carModel.getName());
        carDTO.setBrand(carModel.getBrand());
        carDTO.setModel(carModel.getModel());
        carDTO.setYear(carModel.getYear());
        carDTO.setColor(carModel.getColor());
        return carDTO;
    }

    CarModel carDTO(CarDTO carDTO){
        CarModel carModel = new CarModel();

        carModel.setId(carDTO.getId());
        carModel.setName(carDTO.getName());
        carModel.setBrand(carDTO.getBrand());
        carModel.setModel(carDTO.getModel());
        carModel.setYear(carDTO.getYear());
        carModel.setColor(carDTO.getColor());
        return carModel;
    }
}
