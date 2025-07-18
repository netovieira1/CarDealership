package com.neto.CarDealership.car.repository;

import com.neto.CarDealership.car.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long> {
}
