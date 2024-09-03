package com.example.car.rental.system.dto;

import com.example.car.rental.system.enums.car.AvailabilityStatusType;
import com.example.car.rental.system.enums.car.FuelType;
import com.example.car.rental.system.enums.car.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Long id ;
    private String brand;
    private String model;
    private String color;
    private int year;
    private String vin;
    private double pricePerDay;
    private AvailabilityStatusType availabilityStatus;
    private FuelType fuelType;
    private int seatingCapacity;
    private TransmissionType transmissionType;


}
