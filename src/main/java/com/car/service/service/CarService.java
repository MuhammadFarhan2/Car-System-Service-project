package com.car.service.service;

import com.car.service.model.Car;
import com.car.service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
    public List<Car> getCarList() {
        return carRepository.findAll();
    }

    public Car findCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }
    public String deleteCar(int id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car == null)
            return "Car not found";
        carRepository.delete(car);
        return "Car deleted successfully";
    }
}
