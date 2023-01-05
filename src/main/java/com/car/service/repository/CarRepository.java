package com.car.service.repository;

import com.car.service.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
