package com.neto.CarDealership.client.repository;

import com.neto.CarDealership.client.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    @Query("SELECT c FROM ClientModel c WHERE " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:email IS NULL OR LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%')))")
    Page<ClientModel> findByNameEmail(
            @Param("name") String name,
            @Param("email") String email,
            Pageable pageable
    );

}
