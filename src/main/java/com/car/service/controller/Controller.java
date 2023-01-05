package com.car.service.controller;

import com.car.service.model.Car;
import com.car.service.model.CarRentDetails;
import com.car.service.model.CarWashDetails;
import com.car.service.model.Owner;
import com.car.service.service.CarRentService;
import com.car.service.service.CarService;
import com.car.service.service.CarWashService;
import com.car.service.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private CarService carService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarRentService carRentService;
    @Autowired
    private CarWashService carWashService;


    @PostMapping("/saveOwner")
    public Owner saveOwner(@RequestBody Owner owner)
    {
        return ownerService.save(owner);
    }

    @PostMapping("/saveCar")
    public Car saveCar(@RequestBody Car car)
    { return carService.saveCar(car);  }

    @GetMapping("/getOwnerList")
    public List<Owner> getOwner() {
        return ownerService.getOwnerList();
    }

    @GetMapping("/getCarList")
    public List<Car> getCar() {
        return carService.getCarList();
    }

    @PutMapping("/buycar/{ownerBuyerId}")
     public Owner buyCar(@PathVariable int ownerBuyerId,@RequestBody Car car)
    {
        Owner ownerObj = ownerService.getOwnerById(ownerBuyerId);
        Car carObj = carService.findCarById(car.getCarId());
        try {
            if (carObj != null && ownerObj != null) {
                carObj.setDatePurchased(LocalDate.now());
                carObj.setStatus("buyed");
                carObj.setOwner(ownerObj);
                carService.saveCar(carObj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ownerService.save(ownerObj);
    }

    @PutMapping("/sellcar/{whoBuyCarId}")
    public Owner whoBuyCar(@PathVariable int whoBuyCarId,@RequestBody Car car)
    {
        Owner whoWantToBuyCar = ownerService.getOwnerById(whoBuyCarId);
        Car carObj = carService.findCarById(car.getCarId());
        Owner whoOwnCar = carObj.getOwner();

        if (carObj != null && whoWantToBuyCar != null && whoOwnCar != null) {
            carObj.setDatePurchased(LocalDate.now());
            carObj.setStatus("buyed");
            carObj.setOwner(whoWantToBuyCar);
            carService.saveCar(carObj);
        }
       return ownerService.save(whoWantToBuyCar);
    }

    @PostMapping("/save-car-rent")
    public CarRentDetails saveCarRentDetails(@RequestBody CarRentDetails carRentDetails) {
        Car carWhoOwnIt = carService.findCarById(carRentDetails.getCarId());

        Owner carTenant = ownerService.getOwnerById(carRentDetails.getTenantId());
            carWhoOwnIt.setStatus("rented");
            carRentDetails.setOwnerCarRent(carTenant);
            carService.saveCar(carWhoOwnIt);
        return  carRentService.saveCarRentDetails(carRentDetails);
    }

    @PostMapping("/save-car-wash")
    public CarWashDetails saveCarWash(@RequestBody CarWashDetails carWash) {
        return  carWashService.save(carWash);
    }

    @GetMapping("/get-all-car-wash-details")
    public List<CarWashDetails> getCarWashDetails(){
        return carWashService.carWashDetails();
    }



}
