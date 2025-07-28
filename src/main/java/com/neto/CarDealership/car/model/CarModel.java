package com.neto.CarDealership.car.model;

import com.neto.CarDealership.client.model.ClientModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    private String model;

    private Integer carYear;

    private String color;

    private String plate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel owner;
}
