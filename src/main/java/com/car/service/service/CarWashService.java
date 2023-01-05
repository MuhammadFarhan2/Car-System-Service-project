package com.car.service.service;

import com.car.service.model.CarWashDetails;
import com.car.service.repository.CarWashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarWashService {
    @Autowired
    private CarWashRepository carWashRepository;
    public CarWashDetails save(CarWashDetails carWash) {
        return carWashRepository.save(carWash);
    }
    public CarWashDetails getCarWashById(int id) {
        return carWashRepository.findById(id).get();
    }
    public List<CarWashDetails> carWashDetails() {
        return carWashRepository.findAll();
    }
}
