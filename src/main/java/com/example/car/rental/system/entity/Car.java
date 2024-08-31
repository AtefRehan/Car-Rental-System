package com.example.car.rental.system.entity;

import com.example.car.rental.system.enums.AvailabilityStatusType;
import com.example.car.rental.system.enums.FuelType;
import com.example.car.rental.system.enums.TransmissionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int year;

    @Column(unique = true, nullable = false)
    private String vin;

    @Column(nullable = false)
    private double pricePerDay;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatusType availabilityStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;

    @Column(nullable = false)
    private int seatingCapacity;

    private String color;
}
