package com.neto.CarDealership.user.repository;

import com.neto.CarDealership.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUserName(String username);
 }
