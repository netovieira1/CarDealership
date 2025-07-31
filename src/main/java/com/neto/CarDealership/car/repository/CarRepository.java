package com.neto.CarDealership.car.repository;

import com.neto.CarDealership.car.model.CarModel;
import com.neto.CarDealership.client.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<CarModel, Long> {

    @Query("SELECT c FROM CarModel c WHERE " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:plate IS NULL OR LOWER(c.plate) LIKE LOWER(CONCAT('%', :plate, '%')))")
    Page<CarModel> findByNamePlate(
            @Param("name") String name,
            @Param("plate") String plate,
            Pageable pageable
    );
}
