package com.car.service.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerId;
    private String name;
    private String email;
    private String password;
    private String phone;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private List<Car> ownerCars;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ownerCarRent")
    private List<CarRentDetails> onRentedCarDetails;



}
