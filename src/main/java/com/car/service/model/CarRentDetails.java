package com.car.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentDetails {

    @Id
    @Generated
    private int carRentId;
    private int carId;
    private int ownerId;
    private int tenantId;
    private double rentPrice;
    private Date rentStartDate;
    private Date rentEndDate;

    @ManyToOne
    @JsonBackReference
    private Owner ownerCarRent;
}
