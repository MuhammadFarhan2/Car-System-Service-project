package com.car.service.repository;

import com.car.service.model.CarWashDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarWashRepository extends JpaRepository<CarWashDetails, Integer> {
}
