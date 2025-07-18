package com.neto.CarDealership.client.repository;

import com.neto.CarDealership.client.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
