package com.neto.CarDealership.car.repository;

import com.neto.CarDealership.car.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Long, CarModel> {
}
