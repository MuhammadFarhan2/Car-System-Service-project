package com.car.service.repository;

import com.car.service.model.CarRentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentRepository extends JpaRepository<CarRentDetails, Integer> {
}
