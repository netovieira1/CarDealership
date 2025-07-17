package com.neto.CarDealership.client.model;

import com.neto.CarDealership.car.CarModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String  cpf;

    @OneToMany(mappedBy = "owner")
    private List<CarModel> cars = new ArrayList<>();

}
