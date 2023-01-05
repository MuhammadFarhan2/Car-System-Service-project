package com.car.service.service;

import com.car.service.model.CarRentDetails;
import com.car.service.repository.CarRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentService {
    @Autowired
    private CarRentRepository carRentRepository;

    public CarRentDetails saveCarRentDetails(CarRentDetails carRentDetails) {
        return  carRentRepository.save(carRentDetails);
    }

    public CarRentDetails getCarRentDetailsById(int id) {
        return carRentRepository.findById(id).get();
    }
    public List<CarRentDetails> getAllCarRentDetails(){
        return carRentRepository.findAll();
    }
}
