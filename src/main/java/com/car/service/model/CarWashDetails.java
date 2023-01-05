package com.car.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWashDetails {
    @Id
    @Generated
    private int carWashId;
    private int ownerId;
    private int carId;
    private double price;
    private Date inDate;
    private Date outDate;



}
